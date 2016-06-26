package com.vegaasen.web.service.polish.controller.common;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class UriContext {

    public static final String ROOT = "/";
    public static final String SYSTEM = "system";
    public static final String BRAND = "brand";
    public static final String PAD = "pad";

    public static class PathParam {
        public static final String ENTITY = "{entity}";
        public static final String ENTITY_PADS = "{entity}/pads";
    }

    private UriContext() {
    }

}
