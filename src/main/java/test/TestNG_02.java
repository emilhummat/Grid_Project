package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestNG_02 {
    @Test
    public void Test_01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-12-01&q-check-out=2020-12-02&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
        WebElement currencyButton = driver.findElement(By.cssSelector("button[id='header-toggle-currency']"));
        String defaultCurrencyText=currencyButton.getText();
        currencyButton.click();
        List<WebElement> currencyList = driver.findElements(By.xpath("//div[@class='widget-overlay-bd']//li"));
        Random random=new Random();
        int num = random.nextInt(currencyList.size());
        currencyList.get(num).click();
        String currencyTextAfterChange = driver.findElement(By.cssSelector("button[id='header-toggle-currency']")).getText();
        System.out.println(defaultCurrencyText);
        System.out.println(currencyTextAfterChange);
        Assert.assertNotEquals(defaultCurrencyText,currencyTextAfterChange);
    }
}
/*
Navigate to  https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-12-01&q-check-out=2020-12-02&q-rooms=1&q-room-0-adults=2&q-room-0-children=0

Click on currency menu button on top (by default it is written USD)

Choose any currency (use random)

According to random currency text will also change

Verify currency text is changed in the currency menu

 */
