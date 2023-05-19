package cw.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {



    private static WebDriver driver;
    //todo getDriver methoduna cross browser testing yetisi ekle

    public static WebDriver getDriver(){

        //driver objemiz oluşturulmadıysa driveri oluştur
        if(driver==null){

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;

    }


    public static void closeDriver(){

        if(driver!=null){
            driver.quit();

        }

    }


}
