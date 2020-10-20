package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNG_04 {
    @Test
    public void Test_01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-11-10&q-check-out=2020-11-11&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("Price"))).perform();
        driver.findElement(By.linkText("Price (high to low)")).click();
//        WebDriverWait wait=new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Price"))));
        Thread.sleep(5000);
        List<WebElement> priceList = driver.findElements(By.xpath("//a[@class='price-link'] // strong | //ins "));
        List<Integer> priceInt=new ArrayList<>();

        for (int i = 0; i < priceList.size(); i++) {
            System.out.println(priceList.get(i).getText());
            priceInt.add(Integer.parseInt(priceList.get(i).getText().replaceAll("[^\\d]","")));
        }
        System.out.println(priceInt);
        for (int i = 0; i < priceInt.size()-1; i++) {
            Assert.assertTrue(priceInt.get(i)>=priceInt.get(i+1));

        }
    }
}
/*
Navigate to https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-11-10&q-check-out=2020-11-11&q-rooms=1&q-room-0-adults=2&q-room-0-children=0


Hover over on price in the menu

Click on price high to low

Verify prices are high to low or equal in the hotels list (use "OR" operator in the xpath)
 */