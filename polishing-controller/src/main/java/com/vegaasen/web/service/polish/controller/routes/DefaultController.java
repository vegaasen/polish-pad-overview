package com.vegaasen.web.service.polish.controller.routes;

import com.vegaasen.web.service.polish.controller.common.UriContext;
import com.vegaasen.web.service.polish.controller.model.DefaultInformation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Handles all default requests
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@RestController
@RequestMapping(path = UriContext.ROOT)
public class DefaultController {

    @Resource
    private DefaultInformation defaultInformation;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<DefaultInformation> welcome() {
        return ResponseEntity.ok(defaultInformation);
    }

}
