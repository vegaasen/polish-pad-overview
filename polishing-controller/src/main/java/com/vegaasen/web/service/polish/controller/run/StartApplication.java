package com.vegaasen.web.service.polish.controller.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@SpringBootApplication(
        scanBasePackages = "com.vegaasen.web.service.polish"
)
@EnableAutoConfiguration
public class StartApplication {

    public static void main(String... args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
