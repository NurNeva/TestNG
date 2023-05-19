package Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderHomework_04 {


//    Go to URL: https://www.amazon.com
//Search words: Java, Selenium
//Assert get text result est that the result text contains the searched Word.
//Run tests from XML file.


    protected WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }


    @Test(dataProvider = "getData")
    @Parameters ("searchwords")
    public void test01(String words){

        driver.get("https://www.amazon.com");

        WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys(words + Keys.ENTER);

        WebElement resultText= driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(resultText.getText().contains(words));


    }

    @DataProvider
    public Object[][] getData(){

        return new Object [][]{
                {"Java"},
                {"Selenium"},

        } ;
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
