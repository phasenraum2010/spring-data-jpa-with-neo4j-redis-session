package org.woehlke.neo4j.example.config;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.woehlke.neo4j.example.config.helper.LoggingComponentImpl;

/**
 * Created by tw on 24.06.18.
 */
@Component
public class ApplicationStartingListener extends LoggingComponentImpl implements ApplicationListener<ApplicationStartingEvent> {


    @Override
    protected String[] getLogInfos() {
        return new String[]{
            " ",
            "================================ ",
            "===== Application Started ====== ",
            "================================ ",
            " ",
        };
    }

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        this.logInfo();
    }
}
