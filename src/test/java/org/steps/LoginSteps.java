package org.steps;

import java.awt.AWTException;

import org.junit.Assert;
import org.pages.LoginPage;
import org.pages.SearchHotelPage;
import org.utilities.Libglobal;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends Libglobal {
	@Given("User is on adactin page")
	public void userIsOnAdactinPage() {
	}

	@When("User enters {string} and {string} and Click on Login Button")
	public void userEntersAndAndClickOnLoginButton(String username, String password) {
		LoginPage loginPage = new LoginPage();
		enterValue(loginPage.getTxtUserName(), username);
		enterValue(loginPage.getTxtPassword(), password);
		elementClick(loginPage.getBtnLogin());
	}

	@Then("User verify login sucess message {string}")
	public void userVerifyLoginSucessMessage(String expectedLoginSuccessMsg) {

		SearchHotelPage page = new SearchHotelPage();
		String actualLoginSuccessMsg = getAttributeValue(page.getLoginSuccessMsg(), "value");
		Assert.assertEquals("verify login success msg", expectedLoginSuccessMsg, actualLoginSuccessMsg);

	}

	@Then("User verify login error message {string}")
	public void userVerifyLoginErrorMessage(String expectedLoginErrorMsg) {
		System.out.println(expectedLoginErrorMsg);
	}

	@When("User enters userName and password and press enter key")
	public void userEntersUserNameAndPasswordAndPressEnterKey(io.cucumber.datatable.DataTable d) throws AWTException {
		LoginPage loginPage = new LoginPage();
		enterValue(loginPage.getTxtUserName(), getValue2DWithHeader(d, 0, "userName"));
		enterValue(loginPage.getTxtPassword(), getValue2DWithHeader(d, 0, "password"));
		pressEnter();
	}

}
