package bhargavacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyAcademy.pageobjects.CartPage;
import rahulshettyAcademy.pageobjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="[routerlink*='cart']")
	 WebElement cartIcon;
	 
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderButton;

	public void waitForElementToAppear(By findBy)
	{
		
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}

	
	public void waitForElementToAppear2(WebElement findBy)
	{
		
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	w.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
	w.until(ExpectedConditions.invisibilityOf(ele));
	
	}
	
	public CartPage goToCartPage()
	{
		cartIcon.click();
		CartPage cartPage =new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage()
	{
		orderButton.click();
		OrderPage orderPage =new OrderPage(driver);
		return orderPage;
	}
	
}



