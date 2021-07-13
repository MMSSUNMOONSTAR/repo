package com.FlipKart.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.FlipKart.CommonFunctions.BrowserSetup;

public class FlipKartProductSearch extends BrowserSetup{
	
	@Test
	public void ProductSearch() throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		WebElement searchbox=driver.findElement(By.xpath("//input [contains(@name,'q')]"));
		searchbox.clear(); searchbox.sendKeys("mobiles"+Keys.ENTER);//searchbox.sendKeys("mobiles");
		//WebElement searchicon=driver.findElement(By.xpath("//button [contains(@type,'submit')]"));
		//searchicon.click();
		Thread.sleep(3000);
		screenshot("TestCase3_MobileList");
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,6500)");
		WebElement second=driver.findElement(By.xpath("//a[starts-with(text(),'2')]"));
		//WebElement scrolllast=driver.findElement(By.xpath("//div[starts-with(text(),'POCO M2')]"));
		//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",second);
		Thread.sleep(2000);
		screenshot("TestCase3_BottomPageCountofMobileList");
		second.click();
		Thread.sleep(2000);
		screenshot("TestCase3_2ndPageofMobileList");
	}

}
