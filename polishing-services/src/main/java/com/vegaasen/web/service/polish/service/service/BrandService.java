package com.vegaasen.web.service.polish.service.service;

import com.vegaasen.web.service.polish.common.domain.brand.Brand;

import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
interface BrandService {

    /**
     * Brands registered
     *
     * @return _
     */
    int numberOfBrands();

    /**
     * Fetch all availbe brands
     *
     * @return _
     */
    Set<Brand> getAllBrands();

}
