package com.vegaasen.web.service.polish.service.service.impl;

import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import com.vegaasen.web.service.polish.common.domain.pad.PadToughness;
import com.vegaasen.web.service.polish.common.domain.pad.PadType;
import com.vegaasen.web.service.polish.service.service.PolishService;
import com.vegaasen.web.service.polish.service.util.PolishingUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Service("polishService")
public class PolishServiceImpl implements PolishService {

    public static final int UNDEFINED = -1;
    @Resource
    private PolishingUtils polishingUtils;

    @Override
    public Date getLastUpdated() {
        return polishingUtils.lastModified();
    }

    @Override
    public Date getLastReloaded() {
        return polishingUtils.getReloaded();
    }

    @Override
    public int numberOfBrands() {
        return polishingUtils.get().size();
    }

    @Override
    public Set<Brand> getAllBrands() {
        return polishingUtils.get();
    }

    @Override
    public int numberOfPads() {
        return UNDEFINED;
    }

    @Override
    public Set<Pad> getPads(PadToughness padToughness) {
        return null;
    }

    @Override
    public Set<Pad> getPads(PadType padType) {
        return null;
    }

    @Override
    public Set<Pad> getPads(Brand brand) {
        Optional<Brand> candidate = polishingUtils.get().parallelStream().filter(b -> b.equals(brand)).findFirst();
        return candidate.isPresent() ? candidate.get().getPads() : Collections.emptySet();
    }

    @Override
    public Set<Pad> getPads(Brand... brands) {
        Set<Pad> pads = new HashSet<>();
        for (Brand brand : brands) {
            pads.addAll(getPads(brand));
        }
        return pads;
    }

    @Override
    public Set<Pad> getPads(int from, int to) {
        return null;
    }
}
