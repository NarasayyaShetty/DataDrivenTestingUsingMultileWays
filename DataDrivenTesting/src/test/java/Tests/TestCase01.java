package Tests;

import DP.DPData;
import PropertiesFiles.ExtractDataFromPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static DriverFactory.DriverSingleTon.*;


public class TestCase01 {
    WebDriver driver;
    ExtractDataFromPropertyFile ep=null;

    @Parameters({"browserName","Url"})
    @BeforeClass(alwaysRun = true,description = "initilization the browser")
    public void browserinit(String browserName,String url){
        driver=launchBrowser(browserName);
        launchUrl(url);
        ep=new ExtractDataFromPropertyFile();
    }

    @Test(description="Verify the Register functionality", dataProvider = "testcase01", dataProviderClass = DPData.class)
    public void testCase01(String userName, String password, String confirmPassword) throws InterruptedException {
        driver.findElement(By.xpath(ep.getLocator("Home.register.button.xpath"))).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(ep.getLocator("Register.usernameField.name")))).sendKeys(userName);
        driver.findElement(By.name(ep.getLocator("Register.passwordField.name"))).sendKeys(password);
        driver.findElement(By.name(ep.getLocator("Register.ConfirmPassword.name"))).sendKeys(confirmPassword);
        driver.findElement(By.xpath(ep.getLocator("Register.register.button.xpath"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(ep.getLocator("Login.back.navigation.xpath"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ep.getLocator("Home.register.button.xpath")))).click();


    }
}
