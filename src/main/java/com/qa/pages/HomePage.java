package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class HomePage extends TestBase {

	@FindBy(id="h_sub_menu")
	WebElement subMenu;
	
	@FindBy(xpath="//a[text()='WEATHER']")
	WebElement weatherNavOption;
	
	@FindBy(css="a[class='notnow']")
	WebElement notNow;
	
	public HomePage() {		
		PageFactory.initElements(driver, this);
	}

	public void clickTopNavigationSubMenu() {
		if(driver.findElements(By.xpath("//div[@class='noti_wrap']")).size()>0) {
			notNow.click();
		}
		subMenu.click();
	}
	
	public WeatherPage clickWeatherOptionSubMenu() {
		weatherNavOption.click();
		return new WeatherPage();
	}
}
