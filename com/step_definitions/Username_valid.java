package com.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.Responsevalid;
import drivermanage.Drivermanagers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class Username_valid {
    private WebDriver driver;
    private Responsevalid response;

    public Username_valid() {
        this.driver = Drivermanagers.getDriver();
        this.response = new Responsevalid(driver);
    }

    @Given("the user is on the website IP address")
    public void the_user_is_on_the_website_ip_address() {
        driver.get("https://riverinnovate.com/");
    }

    @When("the user click the contact us link on the mainpage")
    public void the_user_click_the_contact_us_link_on_the_mainpage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader1")));
        response.clickContactUsLinks();
    }

    @When("I Enters the name is {string}")
    public void I_enters_the_name_is(String Username) {
        response.enterUser(Username);
    }

    @When("I enter {string} email field")
    public void i_enter_email_field(String email) {
        response.enterEmaill(email);
    }

    @When("I enter {string} the phone field")
    public void i_enter_the_phone_field(String phone) {
        response.enterPhonee(phone);
    }

    @When("I enter {string} into message field")
    public void i_enter_into_message_field(String message) {
        WebElement messageField = driver.findElement(By.xpath("//*[@id='contact_form']/div[4]/textarea"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", messageField);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(messageField));
        messageField.sendKeys(message);
    }

    @When("clicks the valid Submit button to enter")
    public void clicks_the_valid_submit_button_to_enter() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement submitButton = driver.findElement(By.xpath("//div//*[text()='Send Message']"));

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            submitButton.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", submitButton);
        }
    }

    @Then("the user should see a success message for {string}")
    public void the_user_should_see_a_success_message_for(String expectedMessage) {
        By successMessageLocator = By.xpath("//*[text()='Thank you for reaching out to us!']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        String actualMessage = successMessageElement.getText();

        System.out.println("Actual success message: " + actualMessage);

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Success message is correct.");
        } else {
            System.out.println("Success message is incorrect.");
        }
    }
}
