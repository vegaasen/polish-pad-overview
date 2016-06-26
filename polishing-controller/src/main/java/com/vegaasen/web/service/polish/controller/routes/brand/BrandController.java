package com.vegaasen.web.service.polish.controller.routes.brand;

import com.google.common.base.Strings;
import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import com.vegaasen.web.service.polish.controller.common.UriContext;
import com.vegaasen.web.service.polish.service.service.PolishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@RestController
@RequestMapping(path = UriContext.BRAND)
public class BrandController {

    @Resource(name = "jsonPolishService")
    private PolishService polishService;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Set<Brand>> getAll() {
        return ResponseEntity.ok(polishService.getAllBrands());
    }

    @RequestMapping(path = UriContext.PathParam.ENTITY, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity getBrand(@RequestParam(defaultValue = "", name = "entity") final String name) {
        if (Strings.isNullOrEmpty(name)) {
            ResponseEntity.badRequest().build();
        }
        Brand candidate = polishService.getBrand(name);
        return candidate == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(candidate);
    }

    @RequestMapping(path = UriContext.PathParam.ENTITY_PADS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity getPads(@RequestParam(defaultValue = "", name = "entity") final String uuid) {
        if (Strings.isNullOrEmpty(uuid)) {
            ResponseEntity.badRequest().build();
        }
        Set<Pad> candidates = polishService.getPads(polishService.getBrand(uuid));
        return CollectionUtils.isEmpty(candidates) ? ResponseEntity.notFound().build() : ResponseEntity.ok(candidates);
    }

}
