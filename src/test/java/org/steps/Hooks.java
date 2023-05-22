package org.steps;

import org.utilities.Libglobal;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Libglobal {

	@Before()
	public void beforeScenario() {
		System.out.println("@Before ......");
		launchBrowser("chrome");
		maximizeWindow();
		implicitWait(20);
		pageLoadWait(20);
		openAppUrl("https://adactinhotelapp.com/index.php");
	}

	@After()
	public void afterScenario(Scenario s) {
		System.out.println("@After ......");
		s.embed(takeScreenshot(), "image/png"); // to take the screenshot for every scenario
		deleteCookies(); // to clear browser history
		closeBrowser();// to close browser
	}

}
