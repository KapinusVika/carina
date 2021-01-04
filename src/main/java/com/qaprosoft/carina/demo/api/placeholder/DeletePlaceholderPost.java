package com.qaprosoft.carina.demo.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import java.util.Properties;

public class DeletePlaceholderPost extends AbstractApiMethodV2 {
    public DeletePlaceholderPost(int id) {
        super(null, null, new Properties());
        replaceUrlPlaceholder("api_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));

    }
}
