package com.vegaasen.web.service.polish.service.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import com.vegaasen.web.service.polish.common.domain.pad.PadSpecification;
import com.vegaasen.web.service.polish.common.domain.pad.PadToughness;
import com.vegaasen.web.service.polish.common.domain.pad.PadType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class PolishingUtilsTest {

    private final static Gson GSON_BUILDER = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    @InjectMocks
    private PolishingUtils polishingUtils;

    @Test
    @Ignore("Just use this to generate a new json scheme if you are lazy such as myself :-)")
    public void write_normalProcedure() {
        Set<Brand> brands = new HashSet<>();
        Set<Pad> pads = new HashSet<>();
        Pad pad = new Pad();
        pad.setName("name");
        pad.setDescription("description");
        pad.setDirectLink("http://whereev.er");
        pad.setPadType(PadType.FOAM);
        pad.setSpecification(new PadSpecification(3500, PadToughness.FINE));
        pads.add(pad);
        Brand brand = new Brand();
        brand.setCreated(new Date());
        brand.setDescription("description");
        brand.setName("cool beans");
        brand.setUrl("http://somewhe.re");
        brand.setId(1L);
        brand.setUpdated(new Date());
        brand.setPads(pads);
        brands.add(brand);
        System.out.println(GSON_BUILDER.toJson(brands));

    }

    @Test
    public void get_normalProcedure() {
        Set<Brand> brands = polishingUtils.get();
        assertFalse(brands.isEmpty());
        assertEquals(1, brands.size());
    }

    @Test
    public void lastModified_normalProcedure() {
        Date result = polishingUtils.lastModified();
        assertNotNull(result);
    }

}