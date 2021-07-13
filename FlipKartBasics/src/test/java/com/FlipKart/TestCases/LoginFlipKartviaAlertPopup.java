package com.FlipKart.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.FlipKart.CommonFunctions.BrowserSetup;

public class LoginFlipKartviaAlertPopup extends BrowserSetup {
	
	@Test
	public void LoginFlipkart() throws InterruptedException, IOException
	{
		WebElement id=driver.findElement(By.xpath("//input [contains(@autocomplete,'off')][@class='_2IX_2- VJZDxU']"));
		id.clear(); id.sendKeys("9677119953");
		WebElement password=driver.findElement(By.xpath("//input [contains(@autocomplete,'off')][@type='password']"));
		password.clear(); password.sendKeys("2020mms707");
		screenshot("TestCase2_EnteredIDandPassword");
		Thread.sleep(1000);
		WebElement login=driver.findElement(By.xpath("//button [contains(@type,'submit')][@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		login.click();
		screenshot("TestCase2_LoggedIn2FlipCart");
	}

}
