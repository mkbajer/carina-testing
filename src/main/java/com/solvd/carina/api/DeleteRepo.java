package com.solvd.carina.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${DEMO.url}/repos/${owner}/${repo}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)

public class DeleteRepo extends AbstractApiMethodV2 {

    public DeleteRepo(String owner, String repo) {
        replaceUrlPlaceholder("DEMO.url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        setHeader("Authorization", "Bearer " + Configuration.getRequired("user_token"));
        // could use just the PAT -> personal authentication token from Github
    }
}
