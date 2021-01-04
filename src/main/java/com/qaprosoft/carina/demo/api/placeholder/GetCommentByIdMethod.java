package com.qaprosoft.carina.demo.api.placeholder;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCommentByIdMethod extends AbstractApiMethodV2 {
    public GetCommentByIdMethod(int id){
        super(null, "api/posts/_get_comments/rs_by_id.json");
        replaceUrlPlaceholder("api_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }

}
