package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{
  @FindBy(xpath = "//span[@class='title']")private WebElement checkOutPage2lable;
  @FindBy(xpath = "//button[@name='finish']")private WebElement finishBtn;
  @FindBy(xpath = "//div[text()='Payment Information']")private WebElement paymentInfoLable;
  @FindBy(xpath = "//div[text()='Shipping Information']")private WebElement shippingInfoLable;
  @FindBy(xpath = "//div[text()='Price Total']")private WebElement priceTotalLable;
  
  public CheckOutPage2()
  {
	  PageFactory.initElements(driver, this);
  }
  public String verifyLable()
  {
	 return checkOutPage2lable.getText();
  }
  public String clickOnFinishBtn()
  {
	  finishBtn.click();
	  return driver.getCurrentUrl();
  }
  public String verifypaymentInfoLable()
  {
	  return paymentInfoLable.getText();
  }
  public String verifyshippingInfoLable()
  {
	  return shippingInfoLable.getText();
  }
  public String verifypriceTotalLable()
  {
	  return priceTotalLable.getText();
  }
}
