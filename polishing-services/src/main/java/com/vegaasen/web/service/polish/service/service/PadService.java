package com.vegaasen.web.service.polish.service.service;

import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import com.vegaasen.web.service.polish.common.domain.pad.PadToughness;
import com.vegaasen.web.service.polish.common.domain.pad.PadType;

import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
interface PadService {

    /**
     * Pads registered
     *
     * @return _
     */
    int numberOfPads();

    Set<Pad> getPads();

    /**
     * Get pads based on a specific type of toughness
     *
     * @param padToughness _
     * @return _
     */
    Set<Pad> getPads(PadToughness padToughness);

    /**
     * @param padType
     * @return
     */
    Set<Pad> getPads(PadType padType);

    Set<Pad> getPads(Brand brand);

    Set<Pad> getPads(Brand... brand);

    /**
     * Locate pads that contains a specific range of hardness
     *
     * @param from _
     * @param to   _
     * @return _
     */
    Set<Pad> getPads(int from, int to);

}
