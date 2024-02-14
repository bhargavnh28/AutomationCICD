package rahulshettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhargavacademy.AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent{

	
	WebDriver driver;
		
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"card-body\"]"));	
	 
	 //Page Factory
	 
	 @FindBy(xpath="//div[@class=\"card-body\"]")
	 List<WebElement> products;
	 
	 @FindBy(css=".ng-animating")
	 WebElement spinner;
	 
	 
	 //For Web ELement List
	 By productsBy = By.xpath("//div[@class=\"card-body\"]");
	 By toastMessage = By.id("toast-container");
	 By animation = By.id("toast-container");
	 
	 By addToCart = By.cssSelector("button:last-of-type");
	 
	 public List<WebElement> getProductList()
	 {
		 waitForElementToAppear(productsBy);
		 return products;
	 }
	 
	 public WebElement getProductByName(String productName)
	 {
		 WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		 return prod;
	 }
		
	 public void addProductToCart(String productName)
	 {
		 WebElement prod =  getProductByName(productName);
		 prod.findElement(addToCart).click(); 
		 waitForElementToAppear(toastMessage);
		 waitForElementToDisappear(spinner);
	 }
	
	 
		
	 
	}


