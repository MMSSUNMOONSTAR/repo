package com.FlipKart.TestCases;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.FlipKart.CommonFunctions.BrowserSetup;

public class FlipKartAddtoCart extends BrowserSetup{
	
	@Test
	public void addtocart() throws IOException, InterruptedException
	{
		WebElement id=driver.findElement(By.xpath("//input [contains(@autocomplete,'off')][@class='_2IX_2- VJZDxU']"));
		id.clear(); id.sendKeys("9677119953");
		WebElement password=driver.findElement(By.xpath("//input [contains(@autocomplete,'off')][@type='password']"));
		password.clear(); password.sendKeys("2020mms707");
		Thread.sleep(1000);
		WebElement login=driver.findElement(By.xpath("//button [contains(@type,'submit')][@class='_2KpZ6l _2HKlqd _3AWRsL']"));
		login.click();
		Thread.sleep(1000);
		WebElement searchbox=driver.findElement(By.xpath("//input [contains(@name,'q')]"));
		searchbox.clear(); searchbox.sendKeys("mobiles"+Keys.ENTER);//searchbox.sendKeys("mobiles");
		WebElement prod=driver.findElement(By.xpath("//a[starts-with(@href,'/poco-m3-cool-blue-128')]"));
		prod.click();
		screenshot("TestCase4_ClickingProduct");
		String parentwindow=driver.getWindowHandle();
		Set<String> newwindow=driver.getWindowHandles();
		for(String child:newwindow)
		{
			if(!child.equals(parentwindow))
			{
				driver.switchTo().window(child);
				Thread.sleep(1000);
				WebElement addcart=driver.findElement(By.xpath("//button[starts-with(@class,'_2KpZ6l _2U9uOA _')]"));
				screenshot("TestCase4_ProductInNewWindow");
				addcart.click();
				screenshot("TestCase4_AddtoCart");
				driver.switchTo().window(parentwindow);	
				Thread.sleep(1000);
			}
		}
	}

}
