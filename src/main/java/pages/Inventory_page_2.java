package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import base.TestBase;
import utility.HandleDropDownList;

public class Inventory_page_2 extends TestBase
{
	  //object repository
	 @FindBy(xpath = "//span[@class='title']")private WebElement productsLable;
     @FindBy(xpath = "//a[@class='shopping_cart_link']")private WebElement addToCart;
     @FindBy(xpath = "//span[@class='shopping_cart_badge']")private WebElement cartCount;
     @FindBy(xpath = "//select[@class='product_sort_container']")private WebElement dropDown;
     @FindBy(xpath = "//a[text()='Twitter']")private WebElement twitterLogo;
     @FindBy(xpath = "//a[text()='Facebook']")private WebElement facebookLogo;
     @FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkedinLogo;
    //element added
     @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement backPackProduct;
     @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement backLightProduct;
     @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement boltTShirtProduct;
     @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement fleeceJacketProduct;
     @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement oneSieProduct;
     @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement tShirtProduct;
    //element removed
     @FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")private WebElement removeoneSieProduct;
     @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")private WebElement removebackLightProduct;
     @FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")private WebElement removeboltTShirtProduct;
     @FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removetShirtProduct;
     @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")private WebElement removebackPackProduct;
     @FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removefleeceJacketProduct;
     //constructor
     public Inventory_page_2()
     {
    	 PageFactory.initElements(driver, this);
     }
     public String varifyproductsLable()
     {
    	 return productsLable.getText();
     }
     public boolean varifytritterLogo()
     {
    	 return twitterLogo.isDisplayed();
     }
     public String add6Products()
     {
       HandleDropDownList.handleSelectClass(dropDown, "Price (low to high)");
       backPackProduct.click();
       backLightProduct.click();
       boltTShirtProduct.click();
       fleeceJacketProduct.click();
       oneSieProduct.click();
       tShirtProduct.click();
       addToCart.click();
       return cartCount.getText();
       
     }
     public String remove2Products() throws InterruptedException
     {
    	 add6Products(); 
    	 Thread.sleep(2000);
    	 removebackPackProduct.click();
    	 removefleeceJacketProduct.click();
         return cartCount.getText();
     }
     
}
