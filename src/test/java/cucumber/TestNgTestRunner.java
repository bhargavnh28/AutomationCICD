package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//WHich type of runner - depends on assertions used in code. TestNg or Junit

@CucumberOptions(features="src/test/java/cucumber",glue="rshettyacademy.stepdefinitions",monochrome=true,plugin= {"html:target/cucumber.html"},
tags="@Regression")
public class TestNgTestRunner extends AbstractTestNGCucumberTests{
	
	
	
}
