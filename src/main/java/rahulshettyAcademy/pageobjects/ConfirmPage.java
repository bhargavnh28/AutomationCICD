package rahulshettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bhargavacademy.AbstractComponents.AbstractComponent;

public class ConfirmPage extends AbstractComponent {

	
		WebDriver driver;
		
		public ConfirmPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);	
		}
		
		@FindBy(css=".hero-primary")
		WebElement  lines;
		
		public String orderConfirmMessage()
		{
			
			return lines.getText();
		}
		
		
		
}


