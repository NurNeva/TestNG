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

public class DataProviderHomework_03 {


//   Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.



    protected WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @Test(dataProvider = "getData")
    public void test01(String devices){

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        WebElement emailInput=driver.findElement(By.xpath("//input[@name='email']"));
        emailInput.sendKeys("clarusway@gmail.com");

        WebElement passwordInput= driver.findElement(By.xpath("//input[@name='password']"));

        passwordInput.sendKeys("123456789");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement searchBox=driver.findElement(By.xpath("//input[@name='search']"));
        searchBox.sendKeys(devices);
    }

    @DataProvider
    public Object[][] getData(){

        return new Object [][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"},

        } ;
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}


    

