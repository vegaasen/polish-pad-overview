package com.vegaasen.web.service.polish.service.service;

import java.util.Date;

/**
 * All services related to the polishing stuff (brand and pad) is listed here
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public interface PolishService extends BrandService, PadService {

    Date getLastUpdated();

    Date getLastReloaded();

}
