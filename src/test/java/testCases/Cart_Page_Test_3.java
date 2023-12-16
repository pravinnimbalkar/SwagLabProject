package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page_3;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenShot;

public class Cart_Page_Test_3 extends TestBase
{
    LoginPage login;
    Inventory_page_2 invent;
    Cart_Page_3 cart;
	@BeforeMethod(alwaysRun = true)
	public void Setup() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent= new Inventory_page_2();
		cart=new Cart_Page_3();
		login.loginToApplication();
		invent.add6Products();
		
	}
  @Test(groups = "Sanity")
  public void varifyyourCartTest()
  {
	  String expyourCart="Your Cart";
	  String actyourCart=cart.varifyyourCart();
	  assertEquals(expyourCart, actyourCart);
	  Reporter.log("Your cart Title in cart page = " + actyourCart);
  }
  @Test(groups = {"Retesting","Regression"})
  public void  varifytritterLogoTest()
  {
	  boolean result=invent.varifytritterLogo();
	  assertEquals(result, true);
	  Reporter.log("Visibility of Twitter Logo = " + result);
  }
  @Test(groups = "Retesting")
  public void clickOncheckOutBtnTest()
  {
	  String expURL="https://www.saucedemo.com/checkout-step-one.html";
	  String actURL=cart.clickOncheckOutBtn();
	  Assert.assertEquals(expURL, actURL);
	  Reporter.log("Checkout button will be redirect checkoutpage ="+actURL);
  }
 @AfterMethod(alwaysRun = true)
  public void closeBrowser(ITestResult it) throws IOException
  {
	   if (it.FAILURE==it.getStatus())
	   {
		   CaptureScreenShot.Screenshot(it.getName());
	   }
	   driver.close();
  }
}
