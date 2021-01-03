package Scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utiles.Extentreport;
import utiles.Propertie;
import weatherComparator.RestGenerics.RestLib;

public class RestWeatherApiTest extends Extentreport
{
	Propertie p = new Propertie();
	RestLib lib= new RestLib();
	WeatherModel model = new WeatherModel();
	
	@Test
	public void getResponseBody()
	{
		test=extentReports.createTest("API Result");
		String city=p.getDataFromFile("q");
		String key=p.getDataFromFile("key");
		String units=p.getDataFromFile("units");
		String uri=p.getDataFromFile("URI");
		String Value=lib.getValueFromResponse(city, key, units, uri, "main.temp");
		p.writeIntoFile("temp", Value,"API");
		test.log(Status.PASS, MarkupHelper.createCodeBlock("PASS"));
	}

}
