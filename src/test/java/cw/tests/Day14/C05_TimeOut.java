package cw.tests.Day14;

import org.testng.annotations.Test;

public class C05_TimeOut {



    // time out bir methodun max calisma suresini set eder
    // time out suresi asilirsa nerde kalindiysa orada test exception firlatarak methoddan cikilir

    @Test(timeOut = 1000)
    public void passedTest(){
        System.out.println("Test Passed");
    }

    @Test(timeOut = 1000)
    public void timedOutTest() throws InterruptedException {
        System.out.println("Test timed out");
        Thread.sleep(1500);
        System.out.println("Test timed out...");
    }

}
