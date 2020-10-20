package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestNGPracticeElements {
    public TestNGPracticeElements(WebDriver driver){
        PageFactory.initElements(driver, this); //initElements(driver,this);
    }

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public WebElement lastname;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement id_state;

    @FindBy(id = "postcode")
    public WebElement postcode;

    @FindBy(id = "phone_mobile")
    public WebElement phone_mobile;

    @FindBy(id = "alias")
    public WebElement alias;

    @FindBy(id = "submitAddress")
    public WebElement saveButton;

    @FindBy(xpath = "(//h3[@class='page-subheading'])[2]")
    public WebElement addressVerification;

    @FindBy(xpath = "(//a[@title=\"Update\"])[2]")
    public WebElement updateButton2nd;

    @FindBy(xpath = "(//span[@class='address_name'])[3]")
    public WebElement updatedName;

    @FindBy(xpath = "(//span[@class='address_name'])[4]")
    public WebElement updatedLastName;

    @FindBy(xpath = "(//a[@title='Delete'])[2]")
    public WebElement deleteButton2nd;
}
