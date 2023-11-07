package org.example;

import org.example.PageObject.AmazonHome;
import org.example.Util.Config;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestRunner {

    @BeforeSuite
    public void before(){
        Config.setDriver();
    }

    @Test
    public void test() throws InterruptedException {
        AmazonHome.search();
        Thread.sleep(2000);
        AmazonHome.search_button();
    }

    @AfterSuite
    public void afterSuite(){
        Config.closeWindow(3000);
    }
}
