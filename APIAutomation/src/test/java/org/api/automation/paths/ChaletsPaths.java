package org.api.automation.paths;

import org.api.automation.base.APIBase;

public class ChaletsPaths extends APIBase {

    private static final String BASE_URL = prop.getProperty("baseurl");

    public static final String LOAD_PAGE = BASE_URL + "api/accommodation/property/search";

}
