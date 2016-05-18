package com.vegaasen.web.service.polish.controller.run;

import com.vegaasen.web.service.polish.controller.config.WebConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@EnableAutoConfiguration
public class StartApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder()
                .sources(WebConfiguration.class)//, DbConfiguration.class)
                .logStartupInfo(true)
                .build()
                .run(args);
    }

}
