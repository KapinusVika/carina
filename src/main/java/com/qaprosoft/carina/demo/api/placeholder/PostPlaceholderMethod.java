package com.qaprosoft.carina.demo.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostPlaceholderMethod extends AbstractApiMethodV2 {
    public PostPlaceholderMethod(){
        super("api/posts/_post/rq.json", "api/posts/_post/rs.json");
        replaceUrlPlaceholder("api_url", Configuration.getEnvArg("api_url"));

    }

}
