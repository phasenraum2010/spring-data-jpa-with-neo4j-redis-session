package org.woehlke.neo4j.example.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.woehlke.neo4j.example.config.helper.LoggingComponentImpl;

/**
 * Created by tw on 24.06.18.
 */
@Component
public class ApplicationEnvironmentPreparedListener extends LoggingComponentImpl implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    protected String[] getLogInfos() {
        return new String[]{
            " ",
            "================================ ",
            "===== Environment Prepared ===== ",
            "================================ ",
            " ",
        };
    }

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        this.logInfo();
    }
}
