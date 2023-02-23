package com.scripted.web.accessibility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.scripted.accessibility.main.Accessibility;
import com.scripted.accessibility.reporting.AccessibilityReportEngine;
import com.scripted.dataload.PropertyDriver;
import com.scripted.web.BrowserDriver;
import com.scripted.web.WebHandlers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {
	
	public static WebDriver driver;
	static Set<String> links = new HashSet<>();
	static String url = "";
	Accessibility access;
	static volatile ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	private static String cdir = System.getProperty("user.dir");


	@Before("@CollectalltheValidlinkssofApp")
	public void invokeBrowser1() {
		driver = BrowserDriver.funcGetWebdriver();
	}
	
	@After("@CollectalltheValidlinkssofApp")
	public void closeeBrowser1() {
		AccessibilityReportEngine reportEngine = new AccessibilityReportEngine();
		reportEngine.generateOverallAccessibilityReports();
	}
		

	@Given("I navigate to the application")
	public void iNavigateToTheApplicationUrl1() throws InterruptedException {
		PropertyDriver p = new PropertyDriver();
		p.setPropFilePath("src/main/resources/Web/Properties/Browser.properties");
		String initialUrl = p.readProp("url");
		BrowserDriver.launchWebURL("https://www.savemart.com/");
	}
	
	@Then("I Collect all the valid links of App")
	public void validlinksofApp1() throws Exception {
		links.addAll(WebHandlers.getAlltheValidLinksforWebPage());
		WebHandlers.WriteExcel(cdir + "/src/main/resources/DataFiles/Excel/LinksSaveMart.xlsx", "Investmentsheet", links);
		BrowserDriver.getDriver().quit();
	}

	@Then("I perform accessibility test on all the valid links")
	public void iPerformAccessibilityTestOnTheallPage1() throws Exception {
		List<String> value = WebHandlers.ReadExcel(cdir + "/src/main/resources/DataFiles/Excel/LinksSaveMart.xlsx","Investmentsheet");
		value.stream().parallel().forEach(number -> {
			try {
				generateReport1(number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
	
	public static void generateReport1(String url) throws InterruptedException {
		final WebDriver driver1;
		Boolean proxyStatus = true;
		//String proxy = "165.225.104.32:9400";
		String proxy = "gateway.zscaler.net:9400";
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"C:\\vaishak\\IBX\\skriptmate-basic\\TAF-Scripting\\src\\main\\resources\\Web\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); 
		options.addArguments("enable-automation");
		options.addArguments("--headless"); // only if you are ACTUALLY running headless
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu"); //how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
		options.addArguments("enable-automation");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		if (proxyStatus) {
			options.addArguments("--proxy-server=http://" + proxy);
		}
		driver1 = new ChromeDriver(options);
		System.out.println("Accessibility test for url:- " + url);
		driver1.get(url);
		Accessibility access = new Accessibility(driver1);
		access.generateAccessibilityReportForCurrentPage(driver1.getTitle() ,url);
		driver1.close();
	}
}
