package rahulshettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhargavacademy.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{

	
	WebDriver driver;
		
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 //WebElement userEmail = driver.findElement(By.id("userEmail"));	
	 
	 //Page Factory
	 
	 @FindBy(id="userEmail")
	 WebElement email;
		
	 @FindBy(id="userPassword")
	 WebElement passWord;
	 
	 @FindBy(id="login")
	 WebElement loginButton;
	 
	 @FindBy(css="[class*='flyInOut']")
	 WebElement errorMessage;
	 
	 public ProductCatalog logintoapplication(String emailid,String password)
	 {
		 email.sendKeys(emailid);
		 passWord.sendKeys(password);
		 loginButton.click();
		 ProductCatalog productCatalog = new ProductCatalog(driver);
		 return productCatalog;
		 
	 }
	 
	 
	 public void goTo()
	 {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 
	 public String getErrorMessage()
	 {
		 waitForElementToAppear2(errorMessage);
		 return errorMessage.getText(); 
	 }
	 
	}


