package com.vegaasen.web.service.polish.service.service.impl;

import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import com.vegaasen.web.service.polish.common.domain.pad.PadType;
import com.vegaasen.web.service.polish.service.util.PolishingUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsonPolishServiceImplTest {

    private static final String WHATEVER = "whatever";

    @Mock
    private PolishingUtils polishingUtils;
    @InjectMocks
    private JsonPolishServiceImpl polishService;

    @Before
    public void setUp() {
        assertNotNull(polishService);
    }

    @Test
    public void getLastUpdated_normalProcedure() {
        Date expected = new Date();
        when(polishingUtils.lastModified()).thenReturn(expected);
        assertEquals(expected, polishService.getLastUpdated());
        verify(polishingUtils).lastModified();
    }

    @Test
    public void getNumberOfBrands_normalProcedure() {
        Brand brand = mock(Brand.class);
        when(brand.getPads()).thenReturn(Collections.singleton(mock(Pad.class)));
        when(polishingUtils.get()).thenReturn(Collections.singleton(brand));
        assertEquals(1, polishService.numberOfPads());
        verify(polishingUtils).get();
    }

    @Test
    public void getAllBrands_normalProcedure() {
        when(polishingUtils.get()).thenReturn(Collections.singleton(mock(Brand.class)));
        assertNotNull(polishService.getAllBrands());
        verify(polishingUtils).get();
    }

    @Test
    public void getPads_byType_normalProcedure() {
        Brand brand = mock(Brand.class);
        Pad pad = mock(Pad.class);
        when(pad.getName()).thenReturn(WHATEVER);
        when(pad.getPadType()).thenReturn(PadType.WOOL);
        when(brand.getPads()).thenReturn(Collections.singleton(pad));
        when(polishingUtils.get()).thenReturn(Collections.singleton(brand));
        assertTrue(polishService.getPads(PadType.WOOL).iterator().next().getName().equals(WHATEVER));
        verify(polishingUtils).get();
        verify(pad).getPadType();
    }

}