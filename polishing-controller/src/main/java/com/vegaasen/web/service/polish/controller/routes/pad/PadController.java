package com.vegaasen.web.service.polish.controller.routes.pad;

import com.vegaasen.web.service.polish.controller.common.UriContext;
import com.vegaasen.web.service.polish.service.service.PolishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@RestController
@RequestMapping(path = UriContext.PAD)
public class PadController {

    @Resource
    private PolishService polishService;
    @Resource
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getPads() {
        return ResponseEntity.ok(polishService.getPads());
    }

}
