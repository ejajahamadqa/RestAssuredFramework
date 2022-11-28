package org.api.automation.paths;

import org.api.automation.base.APIBase;

public class HotelPaths extends APIBase {

    private static final String BASE_URL = prop.getProperty("baseurl");

    public static final String SEARCH_HOTEL = BASE_URL + "api/enigma/autocomplete";

}
