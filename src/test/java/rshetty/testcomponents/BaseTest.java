package rshetty.testcomponents;


import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyAcademy.pageobjects.LoginPage;

public class BaseTest {
	

	public WebDriver driver;
	public LoginPage loginPage;
	
	
	public WebDriver intializeDriver() throws IOException
	{
		//properties class
		Properties prop = new Properties();
			
		FileInputStream fileip = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rshetty//resources//GlobalData.properties");
		//FileInputStream fileip = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\rshetty\\resources\\GlobalData.properties");
		prop.load(fileip);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser"); //Ternary operators in Java
		// prop.getProperty("browser");
		System.out.println("The browser is "+browserName);
		
		
		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			//Dimension dimension= new Dimension(1440, 900);
			//driver.manage().window().setSize(dimension);

		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//WebDriver driver = new GeckoDriver();
		
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();

		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	

	private org.openqa.selenium.Dimension Dimension(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read son to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	
		//Convert String To Hashmap - Jackson Datbind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {				
		});
		return data;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//"+testCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" +testCaseName + ".png";
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApllication() throws IOException
	{
		driver = intializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;

	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}
}