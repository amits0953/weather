package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utiles.Extentreport;
import weatherComparator.generics.SeleniumLib;

public class HomePage extends Extentreport
{
	SeleniumLib lib;
	
		
	@FindBy(id="h_sub_menu") private WebElement subMenu;
	@FindBy(className = "allow") private WebElement handleAlert;
	@FindBy(xpath = "//a[text()='WEATHER']") private WebElement weatherLink;
	
	
	public HomePage(WebDriver driver)
	{
		lib = new SeleniumLib(driver);
		PageFactory.initElements(driver,this);
		
	}
	
	/*************************************************************ClickOnSubMenu******************************************/
	public void ClickonSubMenu()
	{
		lib.eWaitForVisible(subMenu, 10);
	lib.mouseOverAndClick(subMenu);	
	test.info("pass");
	}
	/*************************************************************HandleAllow**********************************************/
	public void clickOnAllow()
	{
		lib.eWaitForVisible(handleAlert, 10);
		lib.click(handleAlert);
	}
	/***********************************************************ClickOnWeatherLink*******************************************/
	public void clickonWeatherLink() {
		lib.eWaitForVisible(weatherLink, 10);
	lib.click(weatherLink);
	}
	/***********************************************************VerifyTheScreenTitle******************************************/
	public void verifyTheTitle(String Expected)
	{
		
		lib.validate(lib.pageTitle(), Expected,"");
	}
}
