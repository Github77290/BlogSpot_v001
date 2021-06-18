package com.Blogspot.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Blogspot.Utilities.Log;
import com.Blogspot.globalPage.BasePage;


public class Testautomationpage extends BasePage{
	
	public Testautomationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='titlewrapper']/h1")
	WebElement Title;
	
	
	@FindBy(id="Wikipedia1_wikipedia-search-input")
	WebElement Entertext;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement search;
	
	
	
	@FindBy(xpath="//button[text()='Click Me']")
	WebElement clickme_popup;

	@FindBy(id="datepicker")
	WebElement datepicker;
	
	@FindBy(xpath="//div[@class='ui-datepicker-title']")
	WebElement year_month;
	
	@FindBy(xpath="//div[@class='ui-datepicker-title']/preceding::a[1]")
	WebElement next_btn;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody[1]/tr/td")
	WebElement dates;
	
	@FindBy(id="speed")
	WebElement SelectSpeed;
	
	@FindBy(id="files")
	WebElement Selectfile;
	
	@FindBy(id="number")
	WebElement SelectNumber;
	
	@FindBy(id="products")
	WebElement SelectProduct;
	
	@FindBy(id="animals")
	WebElement SelectAnimals;
	
	public void verifyheadertitle() {
		try {
		String actual=Title.getText();
		System.out.println(actual);
		String expected="Automation Testing Practice";
		if(actual.equals(expected)) {
			System.out.println("displaying correct msg as "+actual+"Test Pass" );
			
		}else {
			System.out.println("displaying incorrect msg as"+actual+"Test Fail");
		}
		Log.info("Sucessfully verify Header Title");
		}catch(Exception e) {
			Log.error("Failed to 'verify header title'");
		}
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	
	public void verifyNewWindows() {
		try {
		Entertext.sendKeys("hello");
		search.click();
		Log.info("Sucessfully verify New Window");
		}catch (Exception e){
			Log.error("Failed to Verify New Window");
		}
		
	}
	public void verifyAlert() {
		try {
		clickme_popup.click();
		Alert alert=getDriver().switchTo().alert();
		String actual=alert.getText();
		System.out.println(actual);
		String expected="Press a button!";
		if(actual.equals(expected)) {
			System.out.println("displaying correct msg as "+actual+"Test Pass" );
			alert.accept();
		}else {
			System.out.println("displaying incorrect msg as"+actual+"Test Fail");
		}
		Log.info("Sucessfully verify Alerts");
		}catch (Exception e){
			Log.error("Failed to Verify Alerts");
		}
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	public void verifyDatepicker() {
		try {
		String month="October 2021";
		String date="25";
		datepicker.click();
		
		while(true) {
			String text=year_month.getText();
			if(text.equals(month)) {
				break;
			}else {
				next_btn.click();
			}
			
			
		}
		
		//getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		getDriver().findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td//a[contains(text(),"+date+")]")).click();
		
		Log.info("Sucessfully verify Datepicker");
		}catch (Exception e){
			Log.error("Failed to Verify Datepicker");
		}
		
		getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
	}
	
	public void verifySelectmenu() {
		try {
		Select select=new Select(SelectSpeed);
		select.selectByVisibleText("Medium");
		List<WebElement> option=select.getOptions();
		for(WebElement e:option) {
			System.out.println(e.getText());
			Log.info(" Verify the Select Speed ");
		}
		Log.error("Failed to Verify the Select Speed ");
		System.out.println();
		
		Select sel=new Select(Selectfile);
		sel.selectByVisibleText("DOC file");
		List<WebElement> option1=sel.getOptions();
		for(WebElement e:option1) {
			System.out.println(e.getText());
			Log.info("Verify the selectfile");
		}		
		Log.error("Failed to Verify the Selectfile ");
		System.out.println();
		
		Select select1=new Select(SelectNumber);
		select1.selectByVisibleText("4");
		List<WebElement> option2=select1.getOptions();
		for(WebElement e:option2) {
			System.out.println(e.getText());
			Log.info("Verify the selectNumber");
		}
		Log.error("Failed to Verify the selectNumber");
		System.out.println();
		
		Select select2=new Select(SelectProduct);
		select2.selectByVisibleText("Iphone");
		List<WebElement> option3=select2.getOptions();
		for(WebElement e:option3) {
			System.out.println(e.getText());
			Log.info("Verify the selectProduct");
		}
		Log.error("Failed to Verify the selectProduct");
		System.out.println();
		
		Select select3=new Select(SelectAnimals);
		select3.selectByVisibleText("Cat");
		List<WebElement> option4=select3.getOptions();
		for(WebElement e:option4) {
			System.out.println(e.getText());
			Log.info("Verify the selectAnimals");
		}Log.error("Failed to Verify the selectAnimals");
	
		}catch (Exception e){
			Log.error("Failed to Verify SelectMenu");
		}
		
		
	}
	
	
	
}
