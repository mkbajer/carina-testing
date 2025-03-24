package com.solvd.carina.api;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class APITest implements IAbstractTest {

    private final String BASE_NAME = "todelete";
    private String createdRepoName;

    @BeforeMethod
    public void beforeTest() {
        createdRepoName = null;
    }

    @Test(description = "getting repo by name")
    public void getRepoTest() {

        GetRepo getRepo = new GetRepo("mkbajer", "market");
        getRepo.callAPIExpectSuccess();
        getRepo.validateResponse();
    }

    @Test(description = "creating new Repo")
    public void postTest() {

        String uniqueRepoName = BASE_NAME + "_" + System.currentTimeMillis();
        createdRepoName = uniqueRepoName;
        PostRepo postRepo = new PostRepo(uniqueRepoName);
        postRepo.callAPIExpectSuccess();
        postRepo.validateResponse();
    }

    @Test(description = "deleting Repo")
    public void testDelete() {

        String uniqueRepoName = BASE_NAME + "_" + System.currentTimeMillis();
        createdRepoName = uniqueRepoName;
        PostRepo postRepo = new PostRepo(uniqueRepoName);
        postRepo.callAPIExpectSuccess();
        postRepo.validateResponse();
        DeleteRepo deleteRepo = new DeleteRepo("mkbajer", uniqueRepoName);
        deleteRepo.callAPIExpectSuccess();
    }
    @AfterMethod
    public void cleanup() {

        if (createdRepoName != null) {
            DeleteRepo deleteRepo = new DeleteRepo("mkbajer", createdRepoName);
            try {
                deleteRepo.callAPIExpectSuccess();
            } catch (Exception e) {
                System.out.println("Cleanup: Repository " + createdRepoName + " have been deleted.");
            }
        }
    }
}
