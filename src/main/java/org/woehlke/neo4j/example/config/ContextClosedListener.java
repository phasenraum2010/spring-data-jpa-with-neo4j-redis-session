package org.woehlke.neo4j.example.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.woehlke.neo4j.example.config.helper.LoggingComponentImpl;

/**
 * Created by tw on 24.06.18.
 */
@Component
public class ContextClosedListener  extends LoggingComponentImpl implements ApplicationListener<ContextClosedEvent> {

    @Override
    protected String[] getLogInfos() {
        return new String[]{
            " ",
            "================================ ",
            "=====    Context Closed   ====== ",
            "================================ ",
            " ",
        };
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        this.logInfo();
    }
}
