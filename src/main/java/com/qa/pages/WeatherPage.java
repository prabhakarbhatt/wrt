package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class WeatherPage extends TestBase{
	
	@FindBy(id="searchBox")
	WebElement txtbox_PinYourCity;
	
	@FindBy(css="//div[@class='leaflet-popup-content-wrapper']")
	WebElement CityWeatherPopupDetails;
	
	public WeatherPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterCityName(String city) {
		txtbox_PinYourCity.sendKeys(city);
	}
	
	public void selectCity(String city) {
		
		WebElement element = driver.findElement(By.xpath("//label[@for='"+ city +"']/input"));
		if(element.getAttribute("checked").equals("checked")) {
			System.out.println(city + " is selected.");
		}
		else {
			element.click();
			System.out.println(city + " is selected.");
		}		
	}
	
	public boolean verifyCityAndTemperatureIsDisplayedOnMap(String city) {
		
		boolean check = driver.findElement(By.xpath("//div[contains(@class,'leaflet-marker-icon')]/div[@title='"+city+"']/div[@class='temperatureContainer']")).isDisplayed();
		check &= driver.findElement(By.xpath("//div[contains(@class,'leaflet-marker-icon')]/div[@title='"+city+"']/div[@class='cityText']")).isDisplayed();
		return check;
	}
	
	public void clickCityOnMap(String city) {
		driver.findElement(By.xpath("//div[contains(@class,'leaflet-marker-icon')]/div[@title='"+city+"']/div[@class='cityText']")).click();
	}
	
	public boolean verifyCityPopupDetailsIsDisplayed() {
		return CityWeatherPopupDetails.isDisplayed();
	}
}
