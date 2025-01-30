package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Responsevalid {

    private WebDriver driver;
    
    @FindBy(xpath="//*[@id=\"append-menu-header\"]/ul/li[5]/a")
    private WebElement contactUsLink;

    @FindBy(xpath = "//*[@id='contact_form']/div[1]/input")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='contact_form']/div[2]/input")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='contact_form']/div[3]/input")
    private WebElement phoneField;

    public Responsevalid(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickContactUsLinks() {
        contactUsLink.click();
    }

    public void enterUser(String username) {
        usernameField.sendKeys(username);
    }

    public void enterEmaill(String email) {
        emailField.sendKeys(email);
    }

    public void enterPhonee(String phone) {
        phoneField.sendKeys(phone);
    }
}
