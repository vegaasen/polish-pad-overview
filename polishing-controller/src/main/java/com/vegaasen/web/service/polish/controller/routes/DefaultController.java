package com.vegaasen.web.service.polish.controller.routes;

import com.vegaasen.web.service.polish.controller.common.UriContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Handles all default requests
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@RestController(UriContext.ROOT)
public class DefaultController {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String welcome() {
        return "heisann" + new Date();
    }

}
