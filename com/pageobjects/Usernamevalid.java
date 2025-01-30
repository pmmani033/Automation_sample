package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Usernamevalid {

    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"append-menu-header\"]/ul/li[5]/a")
    private WebElement contactUsLink;

    @FindBy(xpath="//*[@id=\"contact_form\"]/div[1]/input")
    private WebElement username;

    @FindBy(xpath="//*[@id=\"contact_form\"]/div[2]/input")
    private WebElement email;

    @FindBy(xpath="//*[@id=\"contact_form\"]/div[3]/input")
    private WebElement phone;

    public Usernamevalid(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContactUsLink() {
        contactUsLink.click();
    }

    public void enterUsername(String userName) {
        username.sendKeys(userName);
    }

    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    public void enterPhone(String phone) {
        this.phone.sendKeys(phone);
    }
}
