package utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import groovy.xml.MarkupBuilderHelper;

public class Extentreport implements IReporter {
	/*
	 * public static ExtentHtmlReporter htmlReporter;
	 * 
	 * public static ExtentReports extentReports; public ExtentTest test; public
	 * Extentreport() { String dateName = new
	 * SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new java.util.Date());
	 * extentReports = new ExtentReports(); String path = System.getProperty(
	 * "user.dir" ); String absolutePath = path.replace( "/", "//" );
	 * extentReports.attachReporter(new
	 * ExtentHtmlReporter(absolutePath+"//reports"+dateName+"Comparision.html")); }
	 * 
	 * 
	 * 
	 * @AfterTest public void tearDown() { extentReports.flush(); }
	 */

	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static ExtentTest log;

	public Extentreport() {
		String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		extentReports = new ExtentReports();
		extentReports.attachReporter(new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/report/ComparisionReport " + dateName + ".html"));
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case FAILED Due to below issue : ",
					ExtentColor.RED));
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test case PASSED",ExtentColor.GREEN));			
		}
		else {
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}
	@AfterTest
	public void tearDown()
	{
		extentReports.flush();
	}

}
