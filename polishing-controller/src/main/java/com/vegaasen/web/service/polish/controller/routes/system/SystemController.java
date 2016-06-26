package com.vegaasen.web.service.polish.controller.routes.system;

import com.vegaasen.web.service.polish.controller.common.UriContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@RestController
@RequestMapping(path = UriContext.SYSTEM)
public class SystemController {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getVersion() {
        return ResponseEntity.ok(":-)");
    }

}
