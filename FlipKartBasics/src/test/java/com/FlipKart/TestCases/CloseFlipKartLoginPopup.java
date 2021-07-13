package com.FlipKart.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.FlipKart.CommonFunctions.BrowserSetup;

public class CloseFlipKartLoginPopup extends BrowserSetup {

	@Test
	public void CloseAlertPopup() throws IOException
	{
		screenshot("TestCase1_AlertPopup");
		driver.findElement(By.xpath("//button[starts-with(@class,'_2KpZ6l _2doB4z')]")).click();
		screenshot("TestCase1_Closed_Alert_Popup");
	}
}

