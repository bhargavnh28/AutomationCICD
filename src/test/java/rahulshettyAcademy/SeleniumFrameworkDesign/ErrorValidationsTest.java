package rahulshettyAcademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyAcademy.pageobjects.CartPage;
import rahulshettyAcademy.pageobjects.ConfirmPage;
import rahulshettyAcademy.pageobjects.FinalPage;
import rahulshettyAcademy.pageobjects.LoginPage;
import rahulshettyAcademy.pageobjects.ProductCatalog;
import rshetty.testcomponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=rshetty.testcomponents.Retry.class)
	
	public void loginErrorValidation() throws IOException {
		
		
		
		String productName = "ZARA COAT 3";
		String countryName = "India";
		String productName2 = "ADIDAS ORIGINAL";
		
		
		ProductCatalog productCatalog = loginPage.logintoapplication("bhargavnh28@gmail.com","Goutham@99"); // Log in to the application with given credentials				
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());	
		
	}
	
	@Test(groups= {"ErrorHandling"})
	public void submitorder() throws IOException {
		String productName = "ZARA COAT 3";
		String countryName = "India";
	ProductCatalog productCatalog = loginPage.logintoapplication("bhargavanh28@gmail.com","Goutham@99"); // Log in to the application with given credentials				
	List<WebElement> products = productCatalog.getProductList();  // Get all the products on the page - Returns in the form of List
	
	 
	productCatalog.addProductToCart(productName); //Check for our product ZARA COAT 3 and will add it into cart
	
	CartPage cartPage  = productCatalog.goToCartPage();
	Boolean match = cartPage.verifyproductonCart("ZARA COAT 33");
	Assert.assertFalse(match);
	}
}
