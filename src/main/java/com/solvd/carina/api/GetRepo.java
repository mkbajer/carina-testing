package com.solvd.carina.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${DEMO.api_url}/repos/${owner}/${repo}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "get_try/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetRepo extends AbstractApiMethodV2 {

    public GetRepo(String owner, String repo) {

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }
}
