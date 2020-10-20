package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNG_01 {
    @Test
    public void Test_01() {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-09-15&q-check-out=2020-09-17&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@data-menu='sort-submenu-distance']"))).perform();
        driver.findElement(By.linkText("City center")).click();
        List<WebElement> hotelList = driver.findElements(By.className("p-name"));
        WebDriverWait wait=new WebDriverWait(driver,5);
        while (hotelList.size()<50){
            hotelList = driver.findElements(By.cssSelector(".p-name"));
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",hotelList.get(hotelList.size()-1));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".hotel"), hotelList.size()));
        }
        System.out.println(hotelList.size());
        List<WebElement> distanceInfoList = driver.findElements(By.xpath("//ul[@class='property-landmarks']/li"));
        List<Double>distanceToCityCenter=new ArrayList<>();
        List<Double>distanceToLAX =new ArrayList<>();
        for (int i = 0; i < distanceInfoList.size()-1; i+=2) {
            System.out.println(distanceInfoList.get(i).getText());
            double distance=Double.parseDouble(distanceInfoList.get(i).getText().replaceAll("[A-z]",""));
            distanceToCityCenter.add(distance);
        }

        for (int i = 1; i < distanceInfoList.size()-1; i+=2) {
            System.out.println(distanceInfoList.get(i).getText());
            double distance=Double.parseDouble(distanceInfoList.get(i).getText().substring(0,3));
            distanceToLAX.add(distance);
        }
        SoftAssert sa=new SoftAssert();
        for (int i = 0; i < distanceToCityCenter.size(); i++) {
            sa.assertTrue(distanceToCityCenter.get(i)<10);
        }

        for (int i = 0; i < distanceToLAX.size(); i++) {
            sa.assertTrue(distanceToCityCenter.get(i)<10);
        }

        System.out.println(distanceToCityCenter);
        System.out.println(distanceToLAX);
        sa.assertAll();
    }
}

/*
Navigate to  https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-09-15&q-check-out=2020-09-17&q-rooms=1&q-room-0-adults=2&q-room-0-children=0

In the distance menu choose City center

Scroll down and make sure at least 50 hotels are displayed

Verify all hotels are less than 10 miles from  City center and  Los Angeles Intl. (LAX)

Use TestNG while working onthis task

 */
