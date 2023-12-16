package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenShot;
import utility.ReadData;

public class LoginPageTest extends TestBase
{ 
	LoginPage login;
   @BeforeMethod(alwaysRun = true)
   public void setup() throws InterruptedException, IOException
   {
	   initialization();
	   login=new LoginPage();
   }
   @Test(enabled=true,priority=3,groups = "Sanity")//,dependsOnMethods ="verifyURLOfApplication" )
   public void varifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
   {
	   String expTitle=ReadData.readExcel(0, 0);//swag Lab(0,0)
	   String actTitle=login.varifyTitleOfApplication();
	   Assert.assertEquals(expTitle, actTitle);
   }
   @Test(enabled=true,priority=2,groups = {"Sanity","Retesting"})
   public void verifyURLOfApplication() throws EncryptedDocumentException, IOException
   {
	   String expURL=ReadData.readExcel(0, 1);//https://www.saucedemo.com/(0,1)
	   String actURL=login.verifyURLOfApplication();
	   Assert.assertEquals(expURL, actURL);
   }
   @Test(enabled=true,priority=1)//groups = "Regression")//,dependsOnMethods = "verifyURLOfApplication")
   public void loginToApplicationTest() throws IOException
   {
	   String expURL=ReadData.readExcel(0, 2);//https://www.saucedemo.com/inventory.html(0,2)
	   String actURL=login.loginToApplication();
	   Assert.assertEquals(expURL, actURL);
   }
   @AfterMethod(alwaysRun = true)
   public void closeBrowser(ITestResult it) throws IOException
   {
	   if (it.FAILURE==it.getStatus())
	   {
		   CaptureScreenShot.Screenshot(it.getName());
	   }
	   //report.flush();
	   driver.close();
   }
   
}
