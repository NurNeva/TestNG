package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderHomework_02 {


//    Go to URL: https://opensource-demo.orangehrmlive.com/
//    Login with negative credentilas by Data Provider.
//            Then assert that ‘’Invalid credentials’’ is displayed.



    protected WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @Test (dataProvider = "getData")
    public void test01(String userName, String passWord){

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement user= driver.findElement(By.xpath("//input[@name='username']"));
        WebElement sifre= driver.findElement(By.xpath("//input[@type='password']"));

        user.sendKeys(userName);
        sifre.sendKeys(passWord);

        WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        WebElement invalidText= driver.findElement(By.xpath("//p[text()='Invalid credentials']"));
        Assert.assertTrue(invalidText.isDisplayed(), "Text is not displayed");


    }

    @DataProvider
    public Object[][] getData(){

        return new Object [][]{
                {"admin","123"},
                {"admin123", "Admin"},
                {"test", "Admin123"},
                {"user", "user123"}
        } ;
    }




    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
