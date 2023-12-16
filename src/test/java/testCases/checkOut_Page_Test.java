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
import pages.checkOut_Page;
import utility.CaptureScreenShot;

public class checkOut_Page_Test extends TestBase
{
	LoginPage login;
    Inventory_page_2 invent;
    Cart_Page_3 cart;
    CheckOutPage1 check1;
    CheckOutPage2 check2;
    checkOut_Page finish;
	@BeforeMethod
	public void Setup() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent= new Inventory_page_2();
		cart=new Cart_Page_3();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		finish=new checkOut_Page();
		login.loginToApplication();
		invent.add6Products();
		cart.clickOncheckOutBtn();
		check1.Inputinformation();
		check2.clickOnFinishBtn();
		
	}
	@Test
	public void checkoutCompletelabelTest()
	{
		String expLable="Checkout: Complete!";
		String actLable=finish.verifycheckoutCompletelabel();
		Assert.assertEquals(expLable, actLable);
		Reporter.log(" Lable of checkout page = "+actLable);
	}
	@Test
	public void verifyrightMarkImageTest()
	{
		boolean result=finish.verifyrightMarkImage();
		Assert.assertEquals(result, true);
		Reporter.log(" Visibility of RightMark Image="+ result);
	}
	@Test
	public void verifyyourthankYouTextTest()
	{
		String expLable="Thank you for your order!";
		String actLable=finish.verifyyourthankYouText();
		Assert.assertEquals(actLable, expLable);;
		Reporter.log(" Thank you order text= "+actLable);
	}
	@Test
	public void verifyyourOrderDispatchTextTest()
	{
		String expLable="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actLable=finish.verifyyourOrderDispatchText();
		Assert.assertEquals(expLable, actLable);
		Reporter.log(" Test of Complete your order = "+actLable);
	}
	@Test
	public void clickOnbackHomeBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=finish.clickOnbackHomeBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log(" URL of Home Page="+actURL);
		
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
