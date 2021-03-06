package org.woehlke.neo4j.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.woehlke.neo4j.example.config.helper.LoggingComponent;
import org.woehlke.neo4j.example.config.helper.LoggingComponentImpl;


/**
 * @author Thomas Woehlke
 */
@Component
@Validated
@ConfigurationProperties
public class StorageProperties extends LoggingComponentImpl implements LoggingComponent {

    @NonNull
    @Value("${spring.profiles.active}")
    private String springProfilesActive;

    @Nullable
    @Value("${spring.data.neo4j.URI}")
    private String neo4jUri;

    @NonNull
    @Value("${spring.data.neo4j.indexes.auto.dump.dir}")
    private String generatedIndexesOutputDir="target";

    @NonNull
    @Value("${spring.data.neo4j.indexes.auto.dump.filename}")
    private String generatedIndexesOutputFilename="neo4j_indexes.cypher";

    @Nullable
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Nullable
    @Value("${spring.datasource.driver-class-name}")
    private String datasourceDriverClassName;

    @Nullable
    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Nullable
    @Value("${spring.datasource.password}")
    private String datasourcePassword;


    public String getNeo4jUri() {
        return neo4jUri;
    }

    public void setNeo4jUri(String neo4jUri) {
        this.neo4jUri = neo4jUri;
    }

    public String getSpringProfilesActive() {
        return springProfilesActive;
    }

    public void setSpringProfilesActive(String springProfilesActive) {
        this.springProfilesActive = springProfilesActive;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    public String getDatasourceDriverClassName() {
        return datasourceDriverClassName;
    }

    public void setDatasourceDriverClassName(String datasourceDriverClassName) {
        this.datasourceDriverClassName = datasourceDriverClassName;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public void setDatasourceUsername(String datasourceUsername) {
        this.datasourceUsername = datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public void setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
    }

    public String getGeneratedIndexesOutputDir() {
        return generatedIndexesOutputDir;
    }

    public void setGeneratedIndexesOutputDir(String generatedIndexesOutputDir) {
        this.generatedIndexesOutputDir = generatedIndexesOutputDir;
    }

    public String getGeneratedIndexesOutputFilename() {
        return generatedIndexesOutputFilename;
    }

    public void setGeneratedIndexesOutputFilename(String generatedIndexesOutputFilename) {
        this.generatedIndexesOutputFilename = generatedIndexesOutputFilename;
    }

    protected String[] getLogInfos(){
        String[] logs = {
                "-------------------------------------------------------------",
                "   Neo4J Driver Configuration                                ",
                "-------------------------------------------------------------",
                "   spring.profiles.active = " + this.springProfilesActive + "",
                "-------------------------------------------------------------",
                "   spring.data.neo4j.URI = " + this.neo4jUri + "             ",
                "-------------------------------------------------------------",
                "   spring.datasource.driver-class-name = " + this.datasourceDriverClassName + " ",
                "   spring.datasource.url = " + this.datasourceUrl + "        ",
                "   spring.datasource.url = " + this.datasourceUsername + "   ",
                "   spring.datasource.url = " + this.datasourcePassword + "   ",
                "-------------------------------------------------------------"
        };
        return logs;
    }

}
