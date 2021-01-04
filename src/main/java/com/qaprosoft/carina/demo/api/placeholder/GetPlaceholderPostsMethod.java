package com.qaprosoft.carina.demo.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class GetPlaceholderPostsMethod extends AbstractApiMethodV2 {
    public GetPlaceholderPostsMethod() {
        super(null, "api/posts/_get/rs.json", new Properties());
        replaceUrlPlaceholder("api_url", Configuration.getEnvArg("api_url"));
    }
}
