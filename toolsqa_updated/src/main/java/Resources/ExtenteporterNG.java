package Resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenteporterNG {
	
	static ExtentReports extent;

	
	public static ExtentReports getReportObject()
	{
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate=format.format(date); 
		
		String path = System.getProperty("user.dir")+"/reports/ExecutionReport"+actualdate+".html";
		
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "priya");
		
		
		return extent;

	}
}
