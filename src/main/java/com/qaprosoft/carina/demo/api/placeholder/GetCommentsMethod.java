package com.qaprosoft.carina.demo.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetCommentsMethod extends AbstractApiMethodV2 {
    public GetCommentsMethod(int id) {
        super(null, "api/posts/_get_comments/rs.json", new Properties());
        replaceUrlPlaceholder("api_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }

}
