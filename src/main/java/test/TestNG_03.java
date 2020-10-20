package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNG_03 {
    @Test
    public void Test_01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-11-10&q-check-out=2020-11-11&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
        driver.findElement(By.id("f-label-star-rating-5")).click();
        driver.findElement(By.id("f-label-star-rating-4")).click();
        List<WebElement> hotelList = driver.findElements(By.className("p-name"));
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        while (driver.findElements(By.xpath("//div[@class='info unavailable-info']")).size()==0){
            hotelList = driver.findElements(By.cssSelector(".p-name"));
            js.executeScript("arguments[0].scrollIntoView();",hotelList.get(hotelList.size()-1));
        }
        List<WebElement> ratingList = driver.findElements(By.cssSelector(".star-rating-text.star-rating-text-strong"));
        Thread.sleep(2000);
        System.out.println(ratingList.size());
        for (WebElement rating : ratingList) {
            System.out.println(rating.getText());
            Assert.assertTrue(rating.getText().equals("4-star")||rating.getText().equals("5-star")||rating.getText().equals("4.5-star"));
        }
    }
}
/*
Navigate to   https://www.hotels.com/search.do?resolved-location=CITY%3A1482664%3AUNKNOWN%3AUNKNOWN&destination-id=1482664&q-destination=Manhattan%20Beach,%20California,%20United%20States%20of%20America&q-check-in=2020-11-10&q-check-out=2020-11-11&q-rooms=1&q-room-0-adults=2&q-room-0-children=0

Click on 5 stars and 4 stars checbox on the left

Verify all hotels has between 4 and 5 star
 */