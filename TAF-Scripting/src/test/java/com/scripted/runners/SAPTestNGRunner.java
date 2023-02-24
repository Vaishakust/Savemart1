package com.scripted.runners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import com.scripted.configurations.SkriptmateConfigurations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "Features/SAP", plugin = { "json:target/cucumber.json", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}, glue = {
		"com.scripted.sapstepdefs" }, monochrome = true, tags = { "@SAP"})

public class SAPTestNGRunner extends AbstractTestNGCucumberTests {
	@BeforeSuite
	public void setup() {
		SkriptmateConfigurations.beforeSuite();
	}
	@AfterSuite
	public void teardown() {
		SkriptmateConfigurations.afterSuite();
	}
}
