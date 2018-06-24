package org.woehlke.neo4j.example.config.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by tw on 23.06.18.
 */
public abstract class LoggingComponentImpl implements LoggingComponent {

    protected abstract String[] getLogInfos();

    public void log() {
        for (String logInfo:getLogInfos()){
            LOGGER.debug(logInfo);
        }
    }

    @Override
    public void logDebug() {
        for (String logInfo:getLogInfos()){
            LOGGER.debug(logInfo);
        }
    }

    @Override
    public void logInfo() {
        for (String logInfo:getLogInfos()){
            LOGGER.info(logInfo);
        }
    }

    private static final Log LOGGER = LogFactory.getLog(LoggingComponentImpl.class);
}
