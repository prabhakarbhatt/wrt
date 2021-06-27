package com.qa.util;

import com.qa.testBase.TestBase;

public class Utilities extends TestBase{
	
	public void compareBothTemperature(String tempUi, float tempApi, String tempIn) {
		
		if(tempIn.equalsIgnoreCase("C")) {
			Math.round(tempApi);
			String temperature = Float.toString(tempApi-273);
			if(temperature.equals(tempUi)) {
				System.out.println("Temperature is same Celsius which is " + tempUi);
			}
			
		}
		else if(tempIn.equalsIgnoreCase("F")){
			Math.round(tempApi);
			String temperature = Float.toString(((tempApi-273)*(9/5))+32);
			if(temperature.equals(tempUi)) {
				System.out.println("Temperature is same Fehranheit which is " + tempUi);
			}
		}
		
	}

}
