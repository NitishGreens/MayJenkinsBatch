package org.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.utilities.Libglobal;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting extends Libglobal {

	public static void generateJVMReport(String jsonFile) {

		// mention the report location
		File reportDirectory = new File(getProjectPath() + "\\target");

		// set configuration
		Configuration configuration = new Configuration(reportDirectory, "FacebookWebApplication");

		configuration.addClassifications("platformName", "Windows");
		configuration.addClassifications("platformVersion", "11");
		configuration.addClassifications("buildNo", "FB9434");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

}
