package org.woehlke.neo4j.example.config.helper;

import java.util.List;

/**
 * @author Thomas Woehlke
 */
public interface ConfigurationLogger {

    List<String> configurationLogger(org.neo4j.ogm.config.Configuration configuration);
}
