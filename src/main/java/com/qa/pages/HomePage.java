package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(id="h_sub_menu")
	WebElement subMenu;
	
	@FindBy(linkText="https://social.ndtv.com/static/Weather/report/?pfrom=home-ndtv_topsubnavigation")
	WebElement weatherNavOption;
	
	public HomePage() {		
		PageFactory.initElements(driver, this);
	}

	public void clickTopNavigationSubMenu() {
		subMenu.click();
	}
	
	public WeatherPage clickWeatherOptionSubMenu() {
		weatherNavOption.click();
		return new WeatherPage();
	}
}
