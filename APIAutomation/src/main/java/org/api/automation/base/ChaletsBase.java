package org.api.automation.base;

import java.util.*;

public class ChaletsBase extends APIBase {

    public static Map<String, String> prepareBody() {

        Map body = new HashMap<>();
        Map lookupID = new HashMap<>();
        Map search = new HashMap<>();
        List list = new ArrayList<>();

        search.put("lookupId", Arrays.asList(9));
        search.put("lookupTypeId", "2");

        list.add(search);
        list.add(lookupID);

        body.put("searchCriteria", Arrays.asList(search));
        body.put("sortBy", "rank");
        body.put("sortOrder", "general");
        body.put("rankType", "mobile");
        body.put("pageNo", "1");
        body.put("pageSize", "10");

        return body;
    }

}
