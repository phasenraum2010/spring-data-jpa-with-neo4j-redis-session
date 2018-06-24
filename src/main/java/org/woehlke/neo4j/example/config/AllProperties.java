package org.woehlke.neo4j.example.config;

/**
 * Created by tw on 23.06.18.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
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
public class AllProperties extends LoggingComponentImpl implements LoggingComponent {

    @NonNull
    @Value("${spring.application.name}")
    private String springApplicationName;

    public String getSpringApplicationName() {
        return springApplicationName;
    }

    public void setSpringApplicationName(String springApplicationName) {
        this.springApplicationName = springApplicationName;
    }

    protected String[] getLogInfos(){
        String[] logs = {
            "-------------------------------------------------------------",
            "   spring.application.name = " + this.springApplicationName + " ",
            "-------------------------------------------------------------"
        };
        return logs;
    }

}
