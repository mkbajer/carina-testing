package com.solvd.carina.api;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class GetTest implements IAbstractTest {

    @Test(description = "getting repo by name", priority = 1)
    public void getRepoTest() {

        GetRepo getRepo = new GetRepo("mkbajer", "market");

        getRepo.callAPIExpectSuccess();

        getRepo.validateResponse();
    }

}
