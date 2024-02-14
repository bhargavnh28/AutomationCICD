package rshettyacademy.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyAcademy.pageobjects.CartPage;
import rahulshettyAcademy.pageobjects.ConfirmPage;
import rahulshettyAcademy.pageobjects.FinalPage;
import rahulshettyAcademy.pageobjects.LoginPage;
import rahulshettyAcademy.pageobjects.ProductCatalog;
import rshetty.testcomponents.BaseTest;

public class StepDefinitionImplementation extends BaseTest {

	public LoginPage loginPage;
	public ProductCatalog productCatalog;
	public ConfirmPage confirmPage;
	
	@Given("I landed on Ecommerce Website")
	public void I_landed_on_Ecommerce_Website() throws IOException
	{
		//code
		loginPage = launchApllication();
	}
	
	@Given("^Logged in with username <.+> and password <.+>$")
	public void logged_in_with_username_and_password(String username, String password)
	{
		productCatalog = loginPage.logintoapplication(username,password);
	}

	@When("^I add product <.+> to cart$")
	public void I_add_product_to_cart(String productName){
		
		List<WebElement> products = productCatalog.getProductList();  // Get all the products on the page - Returns in the form of List		
		 
		productCatalog.addProductToCart(productName); //Check for our product ZARA COAT 3 and will add it into cart
		
	}
	 
	@When("^Checkout <.+> and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		CartPage cartPage  = productCatalog.goToCartPage();
		Boolean match = cartPage.verifyproductonCart(productName);
		Assert.assertTrue(match);
		
		FinalPage finalPage = cartPage.checkOut();
		
		finalPage.selecCountry("India");
		confirmPage = finalPage.submitTheOrder();
	}
	
@Then("{string} message is displayed on Confirmation Page")
	public void message_is_displayed_on_Confirmation_Page(String string)
	{
		String confirmMessage = confirmPage.orderConfirmMessage();	
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
}
