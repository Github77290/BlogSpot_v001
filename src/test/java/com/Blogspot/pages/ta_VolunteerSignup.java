package com.Blogspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.Blogspot.globalPage.BasePage;

public class ta_VolunteerSignup extends BasePage{

	public ta_VolunteerSignup(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	@FindBy(xpath="//*[@id=\"RESULT_TextField-1\"]")
	WebElement FirstName;

	@FindBy(xpath="//form[@id='FSForm']/div//div[@id='q3']/input")
	WebElement LastName;
	
	@FindBy(xpath="//form[@id='FSForm']/div//div[@id='q9']/input")
	WebElement phonenumber;
	
	@FindBy(xpath="//form[@id='FSForm']/div//div[@id='q4']/input")
	WebElement country;
	
	@FindBy(xpath="//form[@id='FSForm']/div//div[@id='q6']/input")
	WebElement city;
	
	@FindBy(xpath="//form[@id='FSForm']/div//div[@id='q10']/input")
	WebElement emailid;
	
	@FindBy(xpath="//label[contains(text(),'Male')]")
	WebElement gender;
	
	@FindBy(xpath="//label[contains(text(),'Sunday')]")
	WebElement week_consistance;
	
	@FindBy(xpath="//form[@id='FSForm']/div//div[@id='q11']/select")
	WebElement BTtocontact;
	
	@FindBy(xpath="//div[@class='inline_answer']/input")
	WebElement uploadFile;
	
	@FindBy(id="FSsubmit")
	WebElement submit;
	
	
	
	
	public void verifyVolunteerSignup() {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].sendkeys('prasad')", FirstName);
		//FirstName.sendKeys("prasad");
		LastName.sendKeys("B");
		phonenumber.sendKeys("9988665544");
		country.sendKeys("India");
		city.sendKeys("Hyd");
		emailid.sendKeys("abcd@gmail.com");
		gender.click();
		week_consistance.click();
		Select select=new Select(BTtocontact);
		select.selectByVisibleText("Afternoon");
		uploadFile.click();
		
	}
	
	
	
	
	
	
	
	
	
}
