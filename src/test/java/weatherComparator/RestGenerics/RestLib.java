package weatherComparator.RestGenerics;

import org.testng.Assert;

import Scripts.WeatherModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utiles.Propertie;

public class RestLib 
{
	Propertie p = new Propertie();
	String code=p.getDataFromFile("statusCode").trim();

	public Response getRequest(String cityname,String key,String TempUnit,String uri)
	{
		Response response = RestAssured.given().param("q", cityname).and().param("appid", key).and().param("units", TempUnit).get(uri);	
		 String body=response.getBody().asPrettyString().toString();
		 String statusCode=String.valueOf(response.statusCode());
		  Assert.assertEquals(statusCode, code);
		  return response;
	}
	
	public String getValueFromResponse(String cityname,String key,String TempUnit,String uri,String pathOfElement)
	{
		
		return this.getRequest(cityname, key, TempUnit, uri).jsonPath().getString(pathOfElement);
		 
		
		
	}
	
	
	public WeatherModel apiTemp(WeatherModel model)
	{
		String city=p.getDataFromFile("q");
		String key=p.getDataFromFile("key");
		String units=p.getDataFromFile("units");
		String uri=p.getDataFromFile("URI"); 
		model.setTemprat((int)Double.parseDouble(this.getValueFromResponse(city, key, units, uri, "main.temp")));
		model.setApiType("API");
		return model;
	}
	
}