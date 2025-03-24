package com.solvd.carina.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${DEMO.url}/user/repos", methodType = HttpMethodType.POST)
@ResponseTemplatePath(path = "post_try/rs.json")
@RequestTemplatePath(path = "post_try/rq.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostRepo extends AbstractApiMethodV2 {

    public PostRepo(String uniqueRepoName) {

        replaceUrlPlaceholder("DEMO.url", Configuration.getRequired("api_url"));
        setHeader("Authorization", "Bearer " + Configuration.getRequired("user_token"));
    }

}