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
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.CaptureScreenShot;

public class CheckOutPage1_Test extends TestBase
{
     LoginPage login;
     Inventory_page_2 invent;
     Cart_Page_3 cart;
     CheckOutPage1 check1;
 	@BeforeMethod(alwaysRun = true)
 	public void Setup() throws IOException, InterruptedException
 	{
 		initialization();
 		login=new LoginPage();
 		invent= new Inventory_page_2();
 		cart=new Cart_Page_3();
 		check1=new CheckOutPage1();
 		login.loginToApplication();
 		invent.add6Products();
 		cart.clickOncheckOutBtn();
 	}
     @Test
     public void verifyURLOfCheckOutPage1Test()
     {
    	 String expURL="https://www.saucedemo.com/checkout-step-one.html";
    	 String actURL= check1.verifyURLOfCheckOutPage1();
    	 Assert.assertEquals(expURL, actURL);
    	 Reporter.log( "URL of checkout page1=" +actURL);
     }
     @Test
     public void verifyTitleofApplicationTest()
     {
    	 String expTitle="Checkout: Your Information";
    	 String actTitle=check1.verifyTitleofApplication();
    	 Assert.assertEquals(expTitle, actTitle);
    	 Reporter.log( "Title of check out page" + actTitle);
     }
     @Test
     public void InputinformationTest()
     {
    	 String expURL="https://www.saucedemo.com/checkout-step-two.html";
    	 String actURL= check1.Inputinformation();
    	 Assert.assertEquals(expURL, actURL);
    	 Reporter.log("title of check out page 2 = "+actURL);
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
