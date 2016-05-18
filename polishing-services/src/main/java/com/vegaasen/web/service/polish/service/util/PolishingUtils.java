package com.vegaasen.web.service.polish.service.util;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Component
public class PolishingUtils {

    private static final Logger LOG = LoggerFactory.getLogger(PolishingUtils.class);
    private static final Gson GSON_BUILDER = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    private static final String DEFAULT_LOCATION = "pads/entries.json";

    private Date reloaded;

    @Cacheable(cacheNames = "brands")
    public Set<Brand> get() {
        StringBuilder candidate = new StringBuilder();
        try {
            Files.readAllLines(Paths.get(ClassLoader.getSystemResource(DEFAULT_LOCATION).toURI())).stream().forEach(candidate::append);
            return Sets.newHashSet(GSON_BUILDER.fromJson(candidate.toString(), Brand[].class));
        } catch (Exception e) {
            LOG.error("Unable to fetch brands", e);
        } finally {
            reloaded = new Date();
        }
        return Collections.emptySet();
    }

    @Cacheable
    public Date lastModified() {
        try {
            return new Date(Paths.get(ClassLoader.getSystemResource(DEFAULT_LOCATION).toURI()).toFile().lastModified());
        } catch (URISyntaxException e) {
            LOG.warn("Unable to figure out the last modified date", e);
        }
        return new Date();
    }

    public Date getReloaded() {
        return reloaded;
    }
}
