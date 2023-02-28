package com.scripted.runners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.scripted.configurations.SkriptmateConfigurations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features/visualTesting", plugin = { "json:target/cucumber.json","html:target/cucumber.html","io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm" }, glue = {
"com.scripted.web.webstepdefs" }, monochrome = true,tags = { "@visualtesting"})
public class visualtestingRunner extends AbstractTestNGCucumberTests {
	 /*Enable the below code only if you are not using SkpritmateRunner 
	 Also provide the configuration details in SkriptmateConfigurations\SkriptmateConfig.Properties*/
	
	@BeforeSuite
	public void setup() {
		SkriptmateConfigurations.beforeSuite();
	}

	@AfterSuite
	public void teardown() {
		SkriptmateConfigurations.afterSuite();
	}
}
