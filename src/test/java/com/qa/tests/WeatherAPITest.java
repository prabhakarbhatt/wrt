package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.testBase.TestBase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class WeatherAPITest extends TestBase {

	@Test
	@Parameters("city")
	public void getWeatherDataByCityNameTest(String city) {
		
		Response response = given().when().
				get("api.openweathermap.org/data/2.5/weather?q="+city+"&appid=7fe67bf08c80ded756e598d6f8fedaea");
			int status = response.statusCode();
		
			Assert.assertEquals(status,200);
		
			JsonPath jsonPathEvaluator = response.jsonPath();
			String temperatureReponse = jsonPathEvaluator.get("main/temp");
			System.out.println(temperatureReponse);
		
	}
}
