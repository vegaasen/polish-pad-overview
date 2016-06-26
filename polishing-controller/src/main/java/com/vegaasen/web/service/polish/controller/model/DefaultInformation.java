package com.vegaasen.web.service.polish.controller.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Component
public class DefaultInformation {

    @Value("${hei.sann}")
    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }
}
