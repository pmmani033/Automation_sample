package com.step_definitions;

import org.openqa.selenium.WebDriver;
import com.pageobjects.Registers;
import drivermanage.Drivermanagers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register_checklinks {

	private WebDriver driver;
	private Registers reg;


	public Register_checklinks() {

		this.driver = Drivermanagers.getDriver();
		this.reg= new Registers(driver);
		
	}

	@Given("I am on the Register page")
	public void i_am_on_the_register_page() {
		driver.get("https://demo.automationtesting.in/Register.html");

	}

	@When("I click on the {string} link")
	public void i_click_on_the_link(String string) {
		//driver.findElement(By.linkText("Register")).click();
		reg.clickregister();
	}

	@Then("I should be redirected to the same Register page")
	public void i_should_be_redirected_to_the_same_register_page() {
		String url =driver.getTitle();
		boolean one= url.contains("Register");
		System.out.println(one);

	}


}
