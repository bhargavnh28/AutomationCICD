package rahulshettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bhargavacademy.AbstractComponents.AbstractComponent;

public class FinalPage extends AbstractComponent{

	
	WebDriver driver;
	
	public FinalPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(css="[placeholder=\"Select Country\"]")
	WebElement  countryField;
	
	@FindBy(css=".action__submit")
	WebElement  submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	private WebElement  selectCountry;
	
	By resultsBy = By.cssSelector(".ta-results");
	
	
	public void selecCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(countryField, countryName).build().perform();
		waitForElementToAppear(resultsBy);
		selectCountry.click();
		
	}
	
	public ConfirmPage submitTheOrder()
	{
		submit.click();
		
		return new ConfirmPage(driver);
	}
	
	
	

	
	
	
	
}
