package com.vegaasen.web.service.polish.service.service.impl;

import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import com.vegaasen.web.service.polish.common.domain.pad.PadToughness;
import com.vegaasen.web.service.polish.common.domain.pad.PadType;
import com.vegaasen.web.service.polish.service.service.PolishService;
import com.vegaasen.web.service.polish.service.util.PolishingUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Service("jsonPolishService")
public class JsonPolishServiceImpl implements PolishService {

    private static final int UNDEFINED = -1;

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
    public Brand getBrand(String uuid) {
        return getAllBrands().parallelStream().filter(b -> b.getName().equals(uuid)).findFirst().orElseGet(null);
    }

    @Override
    public Brand getBrand(long id) {
        return getAllBrands().parallelStream().filter(b -> b.getId() == id).findFirst().orElseGet(null);
    }

    @Override
    public int numberOfPads() {
        return getAllPads().size();
    }

    @Override
    public Set<Pad> getPads() {
        return getAllPads();
    }

    @Override
    public Set<Pad> getPads(PadToughness padToughness) {
        Set<Pad> pads = getAllPads();
        return CollectionUtils.isEmpty(pads) ? pads : pads.parallelStream().filter(p -> p.getSpecification().getPadToughness().equals(padToughness)).collect(Collectors.toSet());
    }

    @Override
    public Set<Pad> getPads(PadType padType) {
        Set<Pad> pads = getAllPads();
        return CollectionUtils.isEmpty(pads) ? pads : pads.parallelStream().filter(p -> p.getPadType().equals(padType)).collect(Collectors.toSet());
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

    private Set<Pad> getAllPads() {
        Set<Pad> pads = new HashSet<>();
        polishingUtils.get().parallelStream().forEach(b -> pads.addAll(b.getPads()));
        return pads;
    }
}
