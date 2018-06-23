package org.woehlke.neo4j.example.config;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.woehlke.neo4j.example.config.helper.LoggingComponentImpl;

/**
 * Created by tw on 24.06.18.
 */
@Component
public class ApplicationFailedListener extends LoggingComponentImpl implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    protected String[] getLogInfos() {
        return new String[]{
            " ",
            "================================ ",
            "===== Application Failed ======= ",
            "================================ ",
            " ",
        };
    }

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        this.logInfo();
    }
}
