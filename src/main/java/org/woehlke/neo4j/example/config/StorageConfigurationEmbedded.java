package org.woehlke.neo4j.example.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.drivers.embedded.driver.EmbeddedDriver;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.woehlke.neo4j.example.config.helper.Neo4jConfigurationLogger;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.util.List;


/**
 * @author Mark Angrish, Thomas Woehlke
 */
@Configuration
@Profile({
    "default",
    "devembedded",
    "intembedded",
    "testembedded",
    "prodembedded",
    "travisembedded"
})
@EnableNeo4jRepositories(
	basePackages = "org.woehlke.neo4j.example.storage.neo4j.repository",
	transactionManagerRef = "neo4jTransactionManager"
)
@EnableJpaRepositories(
	basePackages = "org.woehlke.neo4j.example.storage.jpa.repository",
	transactionManagerRef = "jpaTransactionManager"
)
@EnableTransactionManagement
@EnableConfigurationProperties(StorageProperties.class)
public class StorageConfigurationEmbedded {

    private final String packages[] = { "org.woehlke.neo4j.example.storage.neo4j.domain" };

	private final String graphDbFileName  = "target/var/graphDb";

	@Autowired
	private Neo4jConfigurationLogger neo4jConfigurationLogger;

    @Autowired
    private AllProperties allProperties;

    @Autowired
	private StorageProperties storageProperties;

    @Bean
    public Driver neo4jDriver() {
        storageProperties.log();
        allProperties.log();
        LOGGER.debug("   Neo4J Driver Configuration = Embedded : " + this.graphDbFileName + " ");
        LOGGER.debug("-------------------------------------------------------------");
        File db = new File( graphDbFileName );
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( db );
        Driver neo4jDriver = new EmbeddedDriver(graphDb);
        if (neo4jDriver == null) {
            LOGGER.error("");
            LOGGER.error("-------------------------------------------------------------");
            LOGGER.error("   driver == null                                            ");
            LOGGER.error("-------------------------------------------------------------");
            LOGGER.error("");
        } else {
            org.neo4j.ogm.config.Configuration configuration = neo4jDriver.getConfiguration();
            if(configuration == null){
                List<String> logInfos = neo4jConfigurationLogger.configurationLogger(configuration);
                for (String logInfo:logInfos) {
                    LOGGER.debug(logInfo);
                }
            }
        }
        return neo4jDriver;
    }

    @Required
    @Bean
	public SessionFactory sessionFactory(Driver neo4jDriver) {
        return new SessionFactory( neo4jDriver, packages );
	}

    @Bean("jpaTransactionManager")
    public JpaTransactionManager jpaTransactionManager(
        EntityManagerFactory emf
    ){
        LOGGER.info("Initializing JpaTransactionManager from EntityManagerFactory");
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
        return jpaTransactionManager;
    }

    @Bean("neo4jTransactionManager")
    public Neo4jTransactionManager neo4jTransactionManager(
        @Qualifier("sessionFactory")  SessionFactory sessionFactory
    ){
        LOGGER.info("Initializing Neo4jTransactionManager fromm SessionFactory");
        Neo4jTransactionManager neo4jTransactionManager = new Neo4jTransactionManager(sessionFactory);
        return neo4jTransactionManager;
    }

	private static final Log LOGGER = LogFactory.getLog(StorageConfigurationEmbedded.class);
}
