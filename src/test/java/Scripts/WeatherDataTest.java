package Scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageObjects.HomePage;
import pageObjects.NDTVWeatherPage;
import utiles.Propertie;
import weatherComparator.generics.BaseLib;

public class WeatherDataTest extends BaseLib {

	Propertie p = new Propertie();
	HomePage homePage;
	NDTVWeatherPage ndtvWeatherPage;
	static int UItemp;
	ExtentTest node;

	@Test
	public void getWeatherData() throws InterruptedException {
		test = extentReports.createTest("NDTV Results");
		homePage = new HomePage(driver);
		ndtvWeatherPage = new NDTVWeatherPage(driver);

//			homePage.clickOnAllow();

		homePage.ClickonSubMenu();
		homePage.clickonWeatherLink();

		homePage.verifyTheTitle(p.getDataFromFile("Header"));
		// Thread.sleep(10000);

		ndtvWeatherPage.enterText("New Delhi");
		// Thread.sleep(10000);
		ndtvWeatherPage.clickOnCity();

		// Thread.sleep(10000);
		UItemp = Integer.parseInt(ndtvWeatherPage.textUi().replaceAll("℃", ""));
		p.writeIntoFile("Temp", ndtvWeatherPage.textUi().replaceAll("℃", ""), "UI");

	}

	public WeatherModel text(WeatherModel model) {

		model.setTemprat(UItemp);
		model.setApiType("UI");
		return model;
	}
}
