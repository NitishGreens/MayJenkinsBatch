package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.Reporting;
import org.utilities.Libglobal;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features", glue = "org.steps", dryRun = false, monochrome = true, plugin = {
		"pretty", "junit:target\\sample.xml", "html:target",
		"json:target\\output.json" }, snippets = SnippetType.CAMELCASE, tags = { "@Smoke , @Reg" })
public class TestRunner extends Libglobal {

	@AfterClass
	public static void afterScenario() {
		Reporting.generateJVMReport(getProjectPath() + "\\target\\output.json");
	}

}
