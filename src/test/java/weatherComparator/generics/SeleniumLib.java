package weatherComparator.generics;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib {
	WebDriver driver;

	/****************************************
	 * Constructor
	 ********************************************/
	public SeleniumLib(WebDriver driver) {
		this.driver = driver;

	}

	/*********************************************************
	 * mouse over
	 **************************************/

	public void mouseOverAndClick(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
		Reporter.log("Sucessufully MouseOver and Click", true);
	}

	/************************************************************
	 * Click on Button
	 */
	public void click(WebElement element) {
		element.click();
		Reporter.log("Sucessufully  Click", true);
	}

	/************************************************************
	 * verifyPageTitle
	 */
	public String pageTitle() {
		return driver.getTitle();
	}

	/********************************************************
	 * SendKeys
	 */

	public void entervalue(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	/*******************************************************
	 * KeyBoardAction
	 */
	public void keyBoardAction(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	/******************************
	 * verify expected and actual result
	 ************************/

	public void validate(String expected, String actual, String passesMsg) {
		Assert.assertEquals(actual, expected);
		Reporter.log(passesMsg, true);
	}

	/********************************
	 * getText
	 ***********************************************/
	public String getText(WebElement element) {
		return element.getText();
	}

	/**************************************
	 * explicit wait
	 ********************************************/
	public void eWaitForVisible(WebElement element, int secs) {
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/********************************************************************
	 * hard code
	 *********************************/
	public void iSleep(int secs)

	{
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
