package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.WeatherPage;
import com.qa.testBase.TestBase;

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
	}
	
	
	@AfterMethod
	public void tearDown() {
		TestBase.quitBrowser();
	}

}
