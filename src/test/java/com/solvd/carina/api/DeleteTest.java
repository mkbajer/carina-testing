package com.solvd.carina.api;

import org.testng.annotations.Test;

public class DeleteTest {
    @Test(description = "deleting Repo", priority = 2)
    public void testDelete() {
        DeleteRepo deleteRepo = new DeleteRepo("mkbajer", "todelete");
        deleteRepo.callAPIExpectSuccess();
    }
}
