package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page_3;
import pages.CheckOutPage1;
import pages.CheckOutPage2;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenShot;

public class CheckOutPage2Test extends TestBase 
{
	LoginPage login;
    Inventory_page_2 invent;
    Cart_Page_3 cart;
    CheckOutPage1 check1;
    CheckOutPage2 check2;
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent= new Inventory_page_2();
		cart=new Cart_Page_3();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		login.loginToApplication();
		invent.add6Products();
		cart.clickOncheckOutBtn();
		check1.Inputinformation();
	}
    @Test
    public void verifyLableTest()
    {
    	String expLable="Checkout: Overview";
    	String actLable=check2.verifyLable();
    	Assert.assertEquals(expLable, actLable);
    	Reporter.log("Lable of check out page 2 = " +actLable);
    }
    @Test
    public void clickOnFinishBtnTest()
    {
    	String expURL="https://www.saucedemo.com/checkout-complete.html";
    	String actURL=check2.clickOnFinishBtn();
    	Assert.assertEquals(expURL, actURL);
    	Reporter.log("Url of Complete Page = " +actURL);
    }
    @Test
    public void paymentInfoLableTest()
    {
    	String expLable="Payment Information";
    	String actLable=check2.verifypaymentInfoLable();
    	Assert.assertEquals(expLable, actLable);
    	Reporter.log("Lable of Payment Information  = "+actLable);
    }
    @Test
    public void verifyshippingInfoLableTest()
    {
    	String expLable="Shipping Information";
    	String actlable=check2.verifyshippingInfoLable();
    	Assert.assertEquals(expLable, actlable);
    	Reporter.log(" Lable of Shipping Information= "+actlable);
    }
    @Test
    public void verifypriceTotalLableTest()
    {
    	String expLable="Price Total";
    	String actLable=check2.verifypriceTotalLable();
    	Assert.assertEquals(expLable, actLable);
    	Reporter.log(" Lable of Price Total= "+actLable);
    }
    @AfterMethod
    public void closeBrowser(ITestResult it) throws IOException
    {
  	   if (it.FAILURE==it.getStatus())
  	   {
  		   CaptureScreenShot.Screenshot(it.getName());
  	   }
  	   driver.close();
    }
}
