package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports {
   
	
	public static ExtentReports report;
	
	public static ExtentReports getReports() {
		String path = System.getProperty("user.dir")+"\\reports\\report.html";
		ExtentSparkReporter configuration = new ExtentSparkReporter(path);
		configuration.config().setDocumentTitle("Test Reports");
		configuration.config().setReportName("QA Click Test Report");

		report = new ExtentReports();
		report.attachReporter(configuration);
		report.setSystemInfo("Tester","Pritam Singh");
		
		return report;

	}

}
