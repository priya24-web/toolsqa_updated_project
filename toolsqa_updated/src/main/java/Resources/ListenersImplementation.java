	package Resources;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImplementation implements ITestListener {
	static ExtentReports report;
		   ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test case: "+result.getMethod().getMethodName()+" is passed.");


}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test case: "+result.getMethod().getMethodName()+"is failed.");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test case: "+result.getMethod().getMethodName()+"is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		try {
 report=ExtenteporterNG.getReportObject();

	}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
report.flush();
	}

}