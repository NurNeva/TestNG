package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dependsOn_Homework {

//    Create tests that depend on each other
//    Create beforeClass and set up settings.
//    By creating interdependent tests;
//    First go to Facebook.
//    Then go to Google depending on Facebook,
//    Then go to Amazon depending on Google
//    Close the driver.



    protected WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void faceBook(){


        driver.get("https://www.facebook.com/");

        System.out.println("Facebook' a giriş yapıldı");
    }

    @Test (dependsOnMethods = {"faceBook"})
    public void google(){

        driver.get("https://www.google.com/");

        System.out.println("Google' a giriş yapıldı");
    }


    @Test (dependsOnMethods = {"google"})
    public void amazon(){

        driver.get("https://www.amazon.com/");

        System.out.println("Amazon' a giriş yapıldı");
    }


    @AfterClass
    public void tearDown(){

      driver.quit();
    }


}
