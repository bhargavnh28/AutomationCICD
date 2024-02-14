package rahulshettyAcademy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyAcademy.pageobjects.CartPage;
import rahulshettyAcademy.pageobjects.ConfirmPage;
import rahulshettyAcademy.pageobjects.FinalPage;
import rahulshettyAcademy.pageobjects.LoginPage;
import rahulshettyAcademy.pageobjects.OrderPage;
import rahulshettyAcademy.pageobjects.ProductCatalog;
import rshetty.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	public ConfirmPage confirmPage;
	
	@Test(dataProvider="getData",groups= {"PurchaseOrder"})	
	public void submitorder(HashMap<String,String> input) throws IOException {
		
		
		String countryName = "India";
	
		ProductCatalog productCatalog = loginPage.logintoapplication(input.get("email"),input.get("password")); // Log in to the application with given credentials				
		List<WebElement> products = productCatalog.getProductList();  // Get all the products on the page - Returns in the form of List
		
		 
		productCatalog.addProductToCart(input.get("productName")); //Check for our product ZARA COAT 3 and will add it into cart
		
		CartPage cartPage  = productCatalog.goToCartPage();
		Boolean match = cartPage.verifyproductonCart(input.get("productName"));
		Assert.assertTrue(match);
		
		FinalPage finalPage = cartPage.checkOut();
		
		finalPage.selecCountry(countryName);
		confirmPage = finalPage.submitTheOrder();
		
		String confirmMessage = confirmPage.orderConfirmMessage();	
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
	}

	//To verify if the ZARA COAT 3 is in order page
	
	@Test(dependsOnMethods = {"submitorder"})
	public void orderHistory()
	{
		ProductCatalog productCatalog = loginPage.logintoapplication("bhargavanh28@gmail.com","Goutham@99"); // Log in to the application with given credentials				
		OrderPage orderpPage = productCatalog.goToOrderPage();
		Assert.assertTrue(orderpPage.displayproductonCart(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map1 = new HashMap<String, String>();
//		map1.put("email", "bhargavanh28@gmail.com");
//		map1.put("password", "Goutham@99");
//		map1.put("productName", "ZARA COAT 3");
//		
//		HashMap<String,String> map2 = new HashMap<String, String>();
//		
//		map2.put("email", "shetty@gmail.com");
//		map2.put("password", "Iamking@000");
//		map2.put("productName", "ADIDAS ORIGINAL");
		
		
		List<HashMap<String,String>> data  = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rshettyacademy//data//PurchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	

}
