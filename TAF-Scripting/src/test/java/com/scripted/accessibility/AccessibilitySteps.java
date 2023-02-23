package com.scripted.accessibility;

import com.scripted.accessibility.main.Accessibility;
import com.scripted.web.BrowserDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class AccessibilitySteps {

    public static WebDriver driver;
    static Accessibility access;

    @Before("@AccessibilityTest")
    public void invokeBrowser() {

        driver = BrowserDriver.funcGetWebdriver();
    }

    @Given("I navigate to the application url {string}")
    public void iNavigateToTheApplicationUrl(String url) {
        BrowserDriver.launchWebURL(url);
        access = new Accessibility(BrowserDriver.getDriver());

    }

//    @Then("I perform accessibility test on the current page with reference {string}")
//    public void iPerformAccessibilityTestOnTheCurrentPageWithReference(String reference) {
//        access.generateAccessibilityReportForCurrentPage("Home_Page");
//    }

    @And("I generate the summary report for accessibility")
    public void iGenerateTheSummaryReportForAccessibility() {
        access.generateOverallAccessibilityReport();
    }

    @After("@AccessibilityTest")
    public void teardown(){
        access.generateOverallAccessibilityReport();
        BrowserDriver.closeBrowser();
    }


}
