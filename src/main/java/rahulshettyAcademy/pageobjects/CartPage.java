package rahulshettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhargavacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	
	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement>  productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutButton;
	

	
	public FinalPage checkOut()
	{
		checkOutButton.click();
		FinalPage finalPage = new FinalPage(driver);
		return finalPage;
		
	}
	
	
	public boolean verifyproductonCart(String productName)
	{
		Boolean match =	productTitles.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return match;
	}

	
	
	
}
