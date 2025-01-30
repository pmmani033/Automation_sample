package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registers {
	
	private WebDriver driver;
	
	@FindBy(linkText=("Register"))
	WebElement registerlink;
	
	public Registers(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this );
		
	}
	
	
	
	public void clickregister()
	{
		
		registerlink.click();
	}
}
