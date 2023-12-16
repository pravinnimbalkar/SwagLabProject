package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class checkOut_Page extends TestBase
{
   @FindBy(xpath = "//span[@class='title']")private WebElement checkoutCompletelabel;
   @FindBy(xpath = "//img[@class='pony_express']")private WebElement rightMarkImage;
   @FindBy(xpath = "//h2[@class='complete-header']")private WebElement yourthankYouText;
   @FindBy(xpath = "//div[@class='complete-text']")private WebElement yourOrderDispatchText;
   @FindBy(xpath = "//button[@class='btn btn_primary btn_small']")private WebElement backHomeBtn;
   
   public checkOut_Page()
   {
   	PageFactory.initElements(driver, this);
   }
   public String verifycheckoutCompletelabel()
   {
	   return checkoutCompletelabel.getText();
   }
   public boolean verifyrightMarkImage()
   {
	   return rightMarkImage.isDisplayed();
   }
   public String verifyyourthankYouText()
   {
	   return yourthankYouText.getText();
   }
   public String verifyyourOrderDispatchText()
   {
	   return yourOrderDispatchText.getText();
   }
   public String clickOnbackHomeBtn()
   {
	   backHomeBtn.click();
	   return driver.getCurrentUrl();
   }

}
