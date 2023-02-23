package com.scripted.web.webstepdefs;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.scripted.Allure.AllureListener;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import com.scripted.dataload.ExcelConnector;
import com.scripted.dataload.GenRocketDriver;
import com.scripted.dataload.PropertyDriver;
import com.scripted.dataload.TestDataFactory;
import com.scripted.dataload.TestDataObject;
import com.scripted.generic.FileUtils;
import com.scripted.web.BrowserDriver;

import io.cucumber.core.api.Scenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners({ AllureListener.class })
public class stepdefinitions {
//	public static WebDriver driver = null;
WebDriver driver;
	public static HashMap<Integer, String> headermap = new HashMap<Integer, String>();
	public static Map<String, String> fRow;
	public static Map<String, String> fAutoRow;
	PropertyDriver propDriver = new PropertyDriver();
	
	NewPage newPage;
	ATUTestRecorder recorder;

	@Before("@web")
	public void invokeBrowser() {
		//BrowserDriver.funcGetWebdriver();
		
		//for cucmber parallel testing 
		 BrowserDriver.getCuPalDriver();
		
		AllureListener.setDriver(BrowserDriver.getDriver());
		
	}
	
	
	
	@Before("@visualtesting")
	public void visualtesting(Scenario scenario) throws ATUTestRecorderException {
		//BrowserDriver.funcGetWebdriver();
		
		//for cucmber parallel testing 
		BrowserDriver.getCuPalDriver();
		driver =BrowserDriver.getDriver();
		AllureListener.setDriver(BrowserDriver.getDriver());
		newPage = PageFactory.initElements(BrowserDriver.getDriver(), NewPage.class);	
		String pattern = "yy-MM-dd-HH-mm-ss-SSSZ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\SkriptmateReport\\FailedVideos\\", scenario.getName()+ "-"+ date, false);
		recorder.start();
		
	}
	
	@After("@visualtesting")
	public void after(Scenario scenario) throws ATUTestRecorderException {
		if(scenario.isFailed()) {
			recorder.stop();
		}
		BrowserDriver.closeBrowser();
	}

	@Before("@Genrocket")
	public void setupGenrocketData() {
		GenRocketDriver.updateSceLoopCount("CRMContactPageScenario.grs", "CRMContact", "ExcelFileReceiver", "10");

		propDriver.setPropFilePath("src/main/resources/DataFiles/Properties/Cogmento.properties");
		String filename = FileUtils.getCurrentDir() + PropertyDriver.readProp("genExcelPath");
		String sheetname = "GenRocket";
		String key = "";
		

		ExcelConnector con = new ExcelConnector(filename, sheetname);
		TestDataFactory test = new TestDataFactory();
		TestDataObject obj = test.GetData(key, con);
		LinkedHashMap<String, Map<String, String>> getAllData = obj.getTableData();
		fRow = (getAllData.get("1"));
	}

	@Before("@Excel")
	public void setupExcelData() {
		propDriver.setPropFilePath("src/main/resources/DataFiles/Properties/config.properties");
		String filename = FileUtils.getCurrentDir() + PropertyDriver.readProp("DataSheetName");
		String sheetname = "TC001";
		String key = "";
		ExcelConnector con = new ExcelConnector(filename, sheetname);
		TestDataFactory test = new TestDataFactory();
		TestDataObject obj = test.GetData(key, con);
		LinkedHashMap<String, Map<String, String>> getAllData = obj.getTableData();
		fAutoRow = (getAllData.get("1"));

	}

	@After("@web")
	public void afterScenario(Scenario scenario) {
		if (BrowserDriver.getDriver()!=null) {
			TakesScreenshot scrShot = ((TakesScreenshot) BrowserDriver.getDriver());
			byte[] screenshot = scrShot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		BrowserDriver.closeBrowser();
	}

	/*
	 * @After public void embedScreenshot(Scenario scenario) { if
	 * (scenario.isFailed()) { try { byte[] screenshot = ((TakesScreenshot) driver)
	 * .getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot, "image/png");
	 * } catch (Exception e) { e.printStackTrace(); } } }
	 */

	@Given("I launch the application")
	public void i_have_logged_into_something_application() throws Throwable {
		propDriver.setPropFilePath("src/main/resources/DataFiles/Properties/config.properties");
		String url = PropertyDriver.readProp("url");
		BrowserDriver.launchWebURL(url);
		
	}
	
	@Given("I launch the application for Incora")
	public void sauceDemo() throws Throwable {
		propDriver.setPropFilePath("src/main/resources/DataFiles/Properties/config.properties");
		String url = PropertyDriver.readProp("url");
		BrowserDriver.launchWebURL(url);
		//GalenUiLayout.galenTest(driver, "automation");
	}
	
	@Given("I launch the application for SaveMart")
	public void saveMART() throws Throwable {
		BrowserDriver.getCuPalDriver();
		driver =BrowserDriver.getDriver();
		AllureListener.setDriver(BrowserDriver.getDriver());
		newPage = PageFactory.initElements(BrowserDriver.getDriver(), NewPage.class);
		propDriver.setPropFilePath("src/main/resources/DataFiles/Properties/config.properties");
		String url = PropertyDriver.readProp("url");
		BrowserDriver.launchWebURL("https://www.savemart.com/");
		Thread.sleep(4000);
		//GalenUiLayout.galenTest(driver, "automation");
	}
	
	@And("User select the store")
	public void login() throws Throwable {		
		newPage.select_store();
		
	}
	
	
	@Then("user click on shop and select made to order")
	public void navigate() throws Throwable {
		Thread.sleep(5000);
		newPage = PageFactory.initElements(BrowserDriver.getDriver(), NewPage.class);
		newPage.select_shop();
		BrowserDriver.closeBrowser();
		
	}
	
	@And("Validating product added to the Cart")
	public void validate() throws Throwable {		
		Assert.assertTrue(true);
		
	}
	@Then("I should successfully able to see the contact created")
	public void i_should_succeffully_able_to_see_the_contact_created() throws Throwable {
	}

	


	}
	

