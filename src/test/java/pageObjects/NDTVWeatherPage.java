package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Scripts.WeatherModel;
import utiles.Propertie;
import weatherComparator.generics.SeleniumLib;

public class NDTVWeatherPage {
	Propertie p = new Propertie();
	String city = p.getDataFromFile("q");
	SeleniumLib lib;
	String s = "New Delhi";
	@FindBy(xpath = "//div[@class='searchContainer']//input[@type='text']")
	private WebElement enterText;
	@FindBy(xpath = "//div[text()='New Delhi']")
	private WebElement cityOnMap;
	@FindBy(xpath = "//div[@class='temperatureContainer']/ancestor::div[@title='New Delhi']//div//span[@class='tempRedText']")
	private WebElement UiTemp;

	public NDTVWeatherPage(WebDriver driver) {
		lib = new SeleniumLib(driver);
		PageFactory.initElements(driver, this);

	}

	public NDTVWeatherPage()
	{
		
	}
	/**************************************************
	 * Select City
	 ******************************************/
	public void enterText(String cityName) {
		lib.eWaitForVisible(enterText, 10);
		lib.entervalue(enterText, cityName);
		lib.keyBoardAction(enterText);
	}

	/***************************************************
	 * cityOnMap
	 ****************************************/
	public void clickOnCity() {
		lib.iSleep(1);
		lib.eWaitForVisible(cityOnMap, 10);
		lib.click(cityOnMap);
	}

	/****************************************************
	 * getText
	 ******************************************/

	/****************************************************
	 * getText
	 ******************************************/
	public String textUi() {
		lib.eWaitForVisible(UiTemp, 10);

		return lib.getText(UiTemp);
	}

}
