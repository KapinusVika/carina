package com.qaprosoft.carina.demo;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.placeholder.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class APIPlaceholderTest extends AbstractTest {

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "kapinus")
    public void testGetPosts() {
        GetPlaceholderPostsMethod getPlaceholderPostsMethod = new GetPlaceholderPostsMethod();
        getPlaceholderPostsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPlaceholderPostsMethod.callAPI();
        getPlaceholderPostsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "kapinus")
    public void testGetPostById() {
        int id = 1;
        GetPlaceholderPostByIdMethod getPlaceholderPostByIdMethod = new GetPlaceholderPostByIdMethod(id);
        getPlaceholderPostByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getPlaceholderPostByIdMethod.callAPI();
        getPlaceholderPostByIdMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "kapinus")
    public void testDeletePost() {
        int id = 1;
        DeletePlaceholderPost deletePlaceholderPost = new DeletePlaceholderPost(id);
        deletePlaceholderPost.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePlaceholderPost.callAPI();
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "kapinus")
    public void testCreatePost() {
        PostPlaceholderMethod postPlaceholderMethod = new PostPlaceholderMethod();
        postPlaceholderMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postPlaceholderMethod.callAPI();
        postPlaceholderMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "kapinus")
    public void testGetComments() {
        int id = 1;
        GetCommentsMethod getCommentsMethod = new GetCommentsMethod(id);
        getCommentsMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCommentsMethod.callAPI();
        getCommentsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test(description = "JIRA#DEMO-0003")
    @MethodOwner(owner = "kapinus")
    public void testGetCommentById() {
        int id = 1;
        GetCommentByIdMethod getCommentByIdMethod = new GetCommentByIdMethod(id);
        getCommentByIdMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getCommentByIdMethod.callAPI();
        getCommentByIdMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

}
