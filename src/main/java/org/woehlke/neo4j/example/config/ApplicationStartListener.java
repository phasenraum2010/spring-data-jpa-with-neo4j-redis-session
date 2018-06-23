package org.woehlke.neo4j.example.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.woehlke.neo4j.example.config.helper.LoggingComponentImpl;

/**
 * Created by tw on 23.06.18.
 */
@Component
public class ApplicationStartListener extends LoggingComponentImpl implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    protected String[] getLogInfos() {
        return new String[]{
                " ",
                "================================ ",
                "===== Application Started ====== ",
                "================================ ",
                "   " + allProperties.getSpringApplicationName(),
                "-------------------------------------------------------------"
        };
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        this.logInfo();
        storageProperties.logDebug();
        allProperties.logDebug();
    }

    @Autowired
    public ApplicationStartListener(AllProperties allProperties, StorageProperties storageProperties) {
        this.allProperties = allProperties;
        this.storageProperties = storageProperties;
    }

    private final AllProperties allProperties;

    private final StorageProperties storageProperties;

    private static final Log LOGGER = LogFactory.getLog(ApplicationStartListener.class);


}
