package Scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.NDTVWeatherPage;
import utiles.Extentreport;
import utiles.Propertie;
import weatherComparator.RestGenerics.RestLib;

public class Comparator extends Extentreport {
	Propertie p = new Propertie();
	NDTVWeatherPage page= new NDTVWeatherPage();
	WeatherDataTest  dataTest = new WeatherDataTest();
	WeatherModel model = new WeatherModel();
	WeatherModel model1 = new WeatherModel();
	RestLib lib= new RestLib();

	int difference=0;
	@Test
	public void compare()
	{
		test=extentReports.createTest("Result");
		String cityName=p.getDataFromFile("q");
		
		Map<String , List<WeatherModel>> map = new HashMap<String, List<WeatherModel>>();
		List<WeatherModel> list= new ArrayList<WeatherModel>();
		
		list.add(dataTest.text(model));
		list.add(lib.apiTemp(model1));
		map.put(cityName, list);
		
		difference=((map.get(cityName)).get(0).getTemprat())-((map.get(cityName)).get(1).getTemprat());
		if(difference>=2)
		{
			test.log(Status.PASS, "Difference is : "+ difference);
		}
		else
		{
			test.log(Status.PASS, "Difference is more than 2 : "+ difference);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
