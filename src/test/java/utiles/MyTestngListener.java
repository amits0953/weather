package utiles;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import weatherComparator.generics.BaseLib;

public class MyTestngListener implements ITestListener
{
	Logger logger = LoggerFactory.getLogger( getClass().getSimpleName());
    public static int startCount, passedCount, failedCount, skippedCount=0;

    public void onTestStart(ITestResult result)
    {
        startCount++;
        logger.info(result.getName()+"Scripts execution starts ", true);
        String path = System.getProperty( "user.dir" );
        String absolutePath = path.replace( "/", "//" );
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(absolutePath + "//reports//Com.html");
        ExtentReports extend = new ExtentReports();
        extend.attachReporter(reporter);
        extend.createTest("Compare");
        extend.flush();

    }

   
    public void onTestSuccess(ITestResult result)
    {
        passedCount++;
        logger.info(result.getName()+"script pass :)" , true);

    }

  
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

 
    public void onTestFailure(ITestResult result)
    {
        failedCount++;
        Reporter.log(result.getName()+" Script is fail :(", true);
        TakesScreenshot ts = (TakesScreenshot) BaseLib.driver;
        File scrfile = ts.getScreenshotAs(OutputType.FILE);
        File destFile= new File("./ScreenShots/"+result.getName()+".png");
        try {
            Files.copy(scrfile, destFile);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        logger.info("screen shot has been taken ", true);
    }

   
    public void onTestSkipped(ITestResult result)
    {
        skippedCount++;
        logger.info(result.getName()+"script skipped :(" , true);

    }

      
    public void onStart(ITestContext context)
    {
        logger.info("suite execution starts "+ new Date() , true);

    }

    
    public void onFinish(ITestContext context)
    {

        logger.info("suite executions ends "+ new Date(), true);
        System.out.println("Total script executed : "+ startCount);
        System.out.println("total script passed : "+ passedCount);
        System.out.println("toatl script failed : "+ failedCount);
        System.err.println("total script skipped : "+ skippedCount);
    }

}
