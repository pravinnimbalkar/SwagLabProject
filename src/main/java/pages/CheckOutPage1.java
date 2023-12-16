package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{
    @FindBy(xpath = "//span[@class='title']")private WebElement titleofChkOutPage;
    @FindBy(xpath = "//input[@name='firstName']")private WebElement firstnameTextBox;
    @FindBy(xpath = "//input[@name='lastName']")private WebElement lastnameTextBox;
    @FindBy(xpath = "//input[@name='postalCode']")private WebElement zipCodeTextBox;
    @FindBy(xpath = "//input[@name='continue']")private WebElement continueBtn;
    public CheckOutPage1()
    {
    	PageFactory.initElements(driver, this);
    }
    public String verifyURLOfCheckOutPage1()
    {
    	return driver.getCurrentUrl();
    }
    public String verifyTitleofApplication()
    {
    	return titleofChkOutPage.getText();
    }
    public String Inputinformation()
    {
    	firstnameTextBox.sendKeys("Harry");
    	lastnameTextBox.sendKeys("Potter");
    	zipCodeTextBox.sendKeys("444103");
    	continueBtn.click();
    	return driver.getCurrentUrl();
    }
}
