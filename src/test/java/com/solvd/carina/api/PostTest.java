package com.solvd.carina.api;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class PostTest implements IAbstractTest {

    @Test(description = "creating new Repo", priority =2)
    public void postTest() {
        PostRepo postRepo = new PostRepo();
        postRepo.callAPIExpectSuccess();
        postRepo.validateResponse();
    }
}
