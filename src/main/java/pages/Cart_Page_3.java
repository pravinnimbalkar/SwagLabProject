package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;


public class Cart_Page_3 extends TestBase
{
  @FindBy(xpath = "//span[@class='title']")private WebElement yourCart;
  @FindBy(xpath = "//a[text()='Twitter']")private WebElement twitterLogo;
  @FindBy(xpath = "//button[@name='checkout']")private WebElement checkOutBtn;
  public  Cart_Page_3()
  {
	  PageFactory.initElements(driver, this);
  }
  public String varifyyourCart()
  {
	  return yourCart.getText();
  }
  public boolean verifytwitterLogo()
  {
	  return twitterLogo.isDisplayed();
  }
  public String clickOncheckOutBtn() 
  {
	  checkOutBtn.click();
	return driver.getCurrentUrl();
  }
}
