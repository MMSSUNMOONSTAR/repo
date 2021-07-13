package com.FlipKart.CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserSetup {
	public static WebDriver driver;
	public static String browser="chrome";
	public static String url="https://www.flipkart.com/";
	public static String title="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
	
	@BeforeTest
	public void Selectbrowser()
	{
		
	if(browser.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Launching FlipKart url in Chrome Browser");
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		//test.log(Status.INFO, "Launching 75health.com url in Firefox Browser");
		System.out.println("Launching FlipKart url in Firefox Browser");
	}
	else if(browser.equalsIgnoreCase("opera"))
	{
		System.setProperty("webdriver.opera.driver", "operadriver.exe");
		driver=new OperaDriver();
		System.out.println("Launching 75health.com url in Opera Browser");
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		System.setProperty("webdriver.edge.driver", "edgedriver.exe");
		driver=new EdgeDriver();
		System.out.println("Launching FlipKart url in Edge Browser");
	}
	else
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("User not set or wrongly set the browwser name so that it takes Chrome for testscript execution. "
				+ "Launching FlipKart url in Chrome Browser by default");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);
	String actualtitle= driver.getTitle();
	String actualurl=driver.getCurrentUrl();
	Assert.assertEquals(title,actualtitle);
	System.out.println("Title Verified and Welcome to "+actualtitle);
	System.out.println("Actual URL is: "+actualurl);	
	}
	
	@AfterTest
	public void teardown() throws InterruptedException
	{		
		driver.quit();
	}
	public static String screenshot(String name) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("Screenshots",name+"_"+System.currentTimeMillis()+".png"));
		return name;
	}
}
