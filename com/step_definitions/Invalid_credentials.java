package com.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.Usernamevalid;

import drivermanage.Drivermanagers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.time.Duration;

public class Invalid_credentials {
	private WebDriver driver;
	private Usernamevalid usernamevalid;
	private Screenshot screenshot;

	public Invalid_credentials() {
		this.driver = Drivermanagers.getDriver();
		this.usernamevalid = new Usernamevalid(driver);
		this.screenshot = new Screenshot();
	}

	@Given("the user is on website IP addresss")
	public void the_user_is_on_website_ip_addresss() {
		driver.get("https://riverinnovate.com/");
	}

	@When("the user clicks the contact us link on the dashboard")
	public void the_user_clicks_the_contact_us_link_on_the_dashboard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader1")));
		usernamevalid.clickContactUsLink();
	}

	@When("the user Enters the name as {string}")
	public void the_user_enters_the_name_as(String Username) {
		usernamevalid.enterUsername(Username);
	}

	@When("I enter {string} into the email field")
	public void i_enter_into_the_email_field(String email) {
		usernamevalid.enterEmail(email);
	}

	@When("I enter {string} into the phone field")
	public void i_enter_into_the_phone_field(String phone) {
		usernamevalid.enterPhone(phone);
	}

	@When("I enter {string} into the message field")
	public void i_enter_into_the_message_field(String message) {
		try {
			WebElement messageField = driver.findElement(By.xpath("//*[@id=\"contact_form\"]/div[4]/textarea"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", messageField);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(messageField));
			messageField.sendKeys(message);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				screenshot.takescreenshot("enter_message_field");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	@When("clicks the valid Submit button")
	public void clicks_the_valid_submit_button() throws InterruptedException {
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
			try {
				screenshot.takescreenshot("click_submit_button");
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expectedMessage) {
		By validationMessageLocator = By.xpath("//label[@class='error']");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement validationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(validationMessageLocator));

		String actualMessage = validationMessageElement.getText();

		System.out.println("Expected validation message: " + expectedMessage);
		System.out.println("Actual validation message: " + actualMessage);

		if (actualMessage.equals(expectedMessage)) {
			System.out.println("Validation message is correct.");
		} else {
			System.out.println("Validation message is incorrect.");
			try {
                screenshot.takescreenshot("validation_message");
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
	}
}
