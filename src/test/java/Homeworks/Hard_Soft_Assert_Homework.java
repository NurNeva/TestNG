package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hard_Soft_Assert_Homework {


//    Test Case1: Positive Login Test
//    Open page https://practicetestautomation.com/practice-test-login/
//    Type username student into Username field
//    Type password Password123 into Password field
//    Puch Submit button.
//            Verify new page URL contains practicetestautomation.com/logged-in-successfully/
//    Verify new page contains expected text ('Congratulations' or 'successfully logged in')
//    Verify button Log out is displayed on the new page.


    protected WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void hardSoftTest() throws InterruptedException {


        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");

        driver.findElement(By.xpath("//button[@id='submit']")).click();

        Thread.sleep(3000);

        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(ExpectedURL,ActualURL);


        WebElement text=driver.findElement(By.className("has-text-align-center"));
        Assert.assertTrue(text.isDisplayed());

        WebElement logout= driver.findElement(By.xpath("//a[text()='Log out']"));
        Assert.assertTrue(logout.isDisplayed());


        //SoftAssertions

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(ActualURL,ExpectedURL);
        sa.assertEquals(text.getText(),"Congratulations student. You successfully logged in!");
        sa.assertTrue(logout.isDisplayed());
        sa.assertAll();


}


    @AfterClass
    public void tearDown(){

        //driver.quit();
    }



    }

