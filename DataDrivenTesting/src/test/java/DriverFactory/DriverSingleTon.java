package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleTon {
    private static WebDriver driver=null;

    private DriverSingleTon(){}

    public static WebDriver launchBrowser(String browserName){
        if(driver==null){
            switch(browserName){
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                default:
                    System.out.println("please provide proper browser name");
                    break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
    public static void launchUrl(String url){
        driver.get(url);
    }
}
