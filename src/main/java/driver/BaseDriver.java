package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseDriver {
protected static WebDriver driver;
    @BeforeMethod
    public void BeforeMethod() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("browserName", "firefox");
        driver=new RemoteWebDriver(new URL("http://3.16.83.5:4444/wd/hub"),cap);

        driver.manage().window().maximize();
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");

        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();

        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        try{
//        These two elements are showing in the chrome but not in the firefox
            WebElement advancedButton = driver.findElement(By.id("details-button"));
            advancedButton.click();

            //        These two elements are showing in the chrome but not in the firefox
            WebElement ProceedButton = driver.findElement(By.id("proceed-link"));
            ProceedButton.click();
        }catch (NoSuchElementException e){
            System.out.println("This part is just for chrome");
        }

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("asd@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("123qweasd");

        WebElement loginButtonLogPage = driver.findElement(By.cssSelector("input[value='Login']"));
        loginButtonLogPage.click();
    }

}
