package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.ReadData;

public class Inventory_page_2_Test extends TestBase
{
  LoginPage login;
  Inventory_page_2 invent;
  @BeforeMethod(alwaysRun = true)
  public void setup() throws InterruptedException, IOException
  {
	   initialization();
	   login=new LoginPage();
	   invent= new Inventory_page_2();
	   login.loginToApplication();
  }
  @Test(enabled=true,priority=3,groups = "Sanity")
  public void varifyproductsLableTest() throws EncryptedDocumentException, IOException
  {
	  String expLable=ReadData.readExcel(0, 3);//Products(0,3)
	  String actLable=invent.varifyproductsLable();
	  Assert.assertEquals(expLable, actLable);
	  Reporter.log("Lable of Inventory Page =" + actLable);
  }
  @Test(enabled=true,priority=1,groups = "Retesting")
  public void varifytritterLogoTest()
  {
	  boolean result=invent.varifytritterLogo();
	  Assert.assertEquals(result, true);
	  Reporter.log("Visibility of Twitter Logo = " +result);
  }
  @Test(enabled=true,priority=2,groups = {"Retesting","Regression"})
  public void add6ProductsTest() throws EncryptedDocumentException, IOException
  {
	  String expCount=ReadData.readExcel(0, 4);//6(0,4)
	  String actCount=invent.add6Products();
	  Assert.assertEquals(expCount, actCount);
	  Reporter.log( "Total products added to cart = "+ actCount);
    
  }
  @Test(enabled=true,priority=4,groups = {"Retesting","Regression"})
  public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  String expCount=ReadData.readExcel(0, 5);//4(0,5)
	  String actCount=invent.remove2Products();
	  Assert.assertEquals(expCount, actCount);
	  Reporter.log( "Count of product after removing = " + actCount);
  }
  @AfterMethod(alwaysRun = true)
  public void closeBrowser()
  {
	   driver.close();
  }
}
