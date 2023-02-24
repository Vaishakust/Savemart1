package com.scripted.web.webstepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.scripted.web.BrowserDriver;
import com.scripted.web.WebHandlers;
import com.scripted.web.WebWaitHelper;

public class NewPage {
	
	 private WebDriver driver;
	    public NewPage(WebDriver driver) 
	    {
	        this.driver = driver;
	    }
	    
	    @FindBy(id = "store-search-input")
	    private WebElement input_q;
	    @FindBy(xpath = "//*[@id=\"store-details-pane\"]/div/button")
	    private WebElement setasmyStore;  
	    @FindBy(xpath = "//div[@objectspyxpath='objectspy']")
	    private WebElement div_vC;
	    @FindBy(xpath = "//mct-img[@mi-src='https://cdn.savemart.com/site/made-to-order/fried_chicken.jpeg']//div[@class='mct-img']")
	    private WebElement div_Kk; 
	    @FindBy(xpath = "//*[@id='templater_column_cards_60_img_link_1']/mct-img/div")
	    private WebElement madetoorder;
	    @FindBy(xpath = " //*[@id='templater_column_cards_59_img_link_1']/mct-img/div")
	    private WebElement friedChicken;
	    
	    @FindBy(xpath = "//span[normalize-space()='Select Options1234']")
	    private WebElement span_SelectOptions; 
	    
	    @FindBy(xpath = "//a[@aria-label='Shop']//span[contains(text(),'Shop')]")
	    private WebElement span_aoShop;
	    


         public void select_store() throws InterruptedException {
        	 Thread.sleep(5000);
        	 WebWaitHelper.waitForElement(input_q);
        	 WebHandlers.click(input_q);
        	 Thread.sleep(5000);
	    	WebHandlers.enterText(input_q, "GEER GARDENS");
	    	Thread.sleep(3000);
	    	Actions tr = new Actions(BrowserDriver.getDriver());
	    	tr.sendKeys(Keys.DOWN ,Keys.ENTER).build().perform();
	    	 Thread.sleep(7000);
	    	 WebHandlers.click(setasmyStore);
	    	 Thread.sleep(4000);	  
	    }
         
         public void select_shop() throws InterruptedException {
        	 
        	 WebHandlers.click(span_aoShop);
        	 Thread.sleep(7000);
        	 WebHandlers.click(madetoorder);
        	 Thread.sleep(7000);
        	 WebHandlers.click(friedChicken);
        	 Thread.sleep(7000);
        	 WebHandlers.scrollBy(0, 400);
        	 WebHandlers.clickByJsExecutor(span_SelectOptions);
	    	  
	    }
}
