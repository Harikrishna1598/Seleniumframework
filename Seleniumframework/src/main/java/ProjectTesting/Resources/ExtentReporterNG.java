package ProjectTesting.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		
		//ExtentSparkReporter class to set title and other details of the report
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter obj = new ExtentSparkReporter(path);
		obj.config().setReportName("Web application test result");
		obj.config().setDocumentTitle("Test Report");
		
		//ExtentReports class to set tester details
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(obj);
		extent.setSystemInfo("Tester", "Hari krishna");
		return extent;
	}

}
