package org.woehlke.neo4j.example.config.helper;


import org.neo4j.ogm.config.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Thomas Woehlke
 */
@Component
public class ConfigurationLoggerImpl implements ConfigurationLogger {

    @Override
    public List<String> configurationLogger(Configuration configuration) {
        List<String> cnf = new ArrayList<>();
        if (configuration == null) {
            cnf.add("");
            cnf.add("-------------------------------------------------------------");
            cnf.add("   configuration == null                                     ");
            cnf.add("-------------------------------------------------------------");
            cnf.add("");
        } else {
            cnf.add("");
            cnf.add("-------------------------------------------------------------");
            try {
                cnf.add("spring.data.neo4j.DriverClassName: " + configuration.getDriverClassName());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.DriverClassName:  " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.URI = " + configuration.getURI());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.URI = " + npe.getMessage());
            }
            try {
                int i = 0;
                for(String uri: configuration.getURIS()){
                    cnf.add("spring.data.neo4j.URIS ["+ ++i +"] = " +uri);
                }
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.URIS = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.trust.strategy = " + configuration.getTrustStrategy());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.trust.strategy = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.trust.certificate.file = " + configuration.getTrustCertFile());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.trust.certificate.file = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.connection.pool.size = " + configuration.getConnectionPoolSize());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.connection.pool.size = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.connection.liveness.check.timeout = " + configuration.getConnectionLivenessCheckTimeout());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.connection.liveness.check.timeout = " + npe.getMessage());
            }
            try {
                if (configuration.getAutoIndex() != null) {
                    cnf.add("spring.data.neo4j.indexes.auto.dump.dir = " + configuration.getAutoIndex().getName());
                } else {
                    cnf.add("spring.data.neo4j.indexes.auto.dump.dir =  configuration.getAutoIndex() == null ");
                }
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.indexes.auto.dump.dir = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.indexes.auto.dump.dir = " + configuration.getDumpDir());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.indexes.auto.dump.dir = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.indexes.auto.dump.filename = " + configuration.getDumpFilename());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.indexes.auto.dump.filename = " + npe.getMessage());
            }
            try {
                if (configuration.getCredentials() != null) {
                    if (configuration.getCredentials().credentials() != null) {
                        try {
                            cnf.add("spring.data.neo4j.username = " + configuration.getCredentials().credentials().toString());
                        } catch (NullPointerException npe) {
                            cnf.add("spring.data.neo4j.username = " + npe.getMessage());
                        }
                    } else {
                        cnf.add("spring.data.neo4j.username =       configuration.getCredentials().credentials() == null");
                    }
                } else {
                    cnf.add("spring.data.neo4j.username =       configuration.getCredentials() == null");
                }
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.username = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.encryption.level = " + configuration.getEncryptionLevel());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.encryption.level = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.neo4j.ha.properties.file = " + configuration.getNeo4jHaPropertiesFile());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.neo4j.ha.properties.file = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.connection.pool.size = " + configuration.getConnectionPoolSize());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.connection.pool.size = " + npe.getMessage());
            }
            try {
                cnf.add("spring.data.neo4j.verify.connection = " + configuration.getVerifyConnection());
            } catch (NullPointerException npe) {
                cnf.add("spring.data.neo4j.verify.connection = " + npe.getMessage());
            }
            cnf.add("-------------------------------------------------------------");
            cnf.add("");
        }
        return cnf;
    }

}
