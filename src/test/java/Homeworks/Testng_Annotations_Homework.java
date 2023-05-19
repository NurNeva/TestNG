package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testng_Annotations_Homework {

//    Create a class.
//    Create 2 test methods.
//    Use TestNG annotations that can be used in the class.
//    Interpret output in console.

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();



    }

    @Test
    public void test01() {

        driver.get("https://www.amazon.com/");

        String title= driver.getTitle();

        Assert.assertTrue(title.contains("Amazon"));

    }


    @Test
    public void test02(){

        driver.get("https://automationexercise.com/login");

        WebElement newUserName=driver.findElement(By.xpath("//input[@placeholder='Name']"));
        newUserName.sendKeys("Jonny");
        WebElement newUserMail= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        newUserMail.sendKeys("jofoc73313@syinxun.com");
        WebElement signUp= driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signUp.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
    }

    @AfterMethod
    public void tearDown(){

        //driver.quit();
    }
}
