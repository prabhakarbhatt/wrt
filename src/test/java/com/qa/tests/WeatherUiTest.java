package com.qa.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.WeatherPage;
import com.qa.testBase.TestBase;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class WeatherUiTest extends TestBase{

	HomePage homePage;
	WeatherPage weatherPage;
	public WeatherUiTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() {
		TestBase.initialise();
		homePage = new HomePage();
		
	}
	
	@Test
	@Parameters("city")
	public void validateWeatherInUITest(String city) {
		homePage.clickTopNavigationSubMenu();
		weatherPage = homePage.clickWeatherOptionSubMenu();
		weatherPage.enterCityName(city);
		weatherPage.selectCity(city);
		Assert.assertTrue(weatherPage.verifyCityAndTemperatureIsDisplayedOnMap(city));
		weatherPage.clickCityOnMap(city);
		Assert.assertTrue(weatherPage.verifyCityPopupDetailsIsDisplayed());
	
	
		Response response = given().when().
			get("api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+prop.getProperty("appid"));
		int status = response.statusCode();
	
		Assert.assertEquals(status,200);
	
		JsonPath jsonPathEvaluator = response.jsonPath();
		String temperatureReponse = jsonPathEvaluator.get("main/temp");
		
		
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		TestBase.quitBrowser();
	}

}
