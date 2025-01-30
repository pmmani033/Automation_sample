package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
             features= "src/test/resources/features" ,
             glue ="com.step_definitions",
             dryRun = false,
             monochrome = true,
             tags ="@firstone",
             plugin = {"pretty" , "html:target/cucumberReports.html","json:target/cucumber.json",
            		 "junit:target/cucumber-reports/Cucumber.xml"}

)
public class TestRunner {
	

}
