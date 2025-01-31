package com.actitime_automation.SuitExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InstagramTC {
    @BeforeTest
    public void readStageEnvironmentDetails() {
        System.out.println("Read STAGE Environment Details");
    }
    @AfterTest
    public void closeClearStageObjectDetails() {
        System.out.println("Clear/Close STAGE Environment Details");
    }
    @Test
    public void addInstagram() {
        System.out.println("Add Instagram");
    }
    @Test
    public void updateInstagram() {
        System.out.println("Update Instagram");
    }
    @Test
    public void deleteInstagram() {
        System.out.println("Delete Instagram");
    }
}
