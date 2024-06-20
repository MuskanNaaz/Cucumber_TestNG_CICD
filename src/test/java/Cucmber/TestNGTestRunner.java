package Cucmber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucmber", glue = "AutomationAcademy.stepDefinitation", monochrome = true,
plugin = {"html:target/cucmber.html"})

//tag 
//cucmber ->TestNG runner to run the feature file, Junit:depends upon the assertion in our code

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	

}
