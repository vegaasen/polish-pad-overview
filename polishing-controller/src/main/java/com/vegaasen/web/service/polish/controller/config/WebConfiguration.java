package com.vegaasen.web.service.polish.controller.config;

import com.vegaasen.web.service.polish.service.config.ServiceConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Import(ServiceConfiguration.class)
@SpringBootApplication(scanBasePackages = "com.vegaasen.web.service.polish.controller")
public class WebConfiguration {
}
