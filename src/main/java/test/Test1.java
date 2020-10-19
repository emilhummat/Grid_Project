package test;

import driver.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test1 extends BaseDriver {
    @Test
    public void SimpleTest(){

        WebElement AddressBookButton = driver.findElement(By.linkText("Address Book"));
        AddressBookButton.click();
        String text = driver.findElement(By.xpath("(//td[@class='text-left'])[1]")).getText();
        System.out.println(text);
    }
}
