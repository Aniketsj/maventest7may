package com.test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loginpagetest {

	WebDriver dr;
	
	@BeforeMethod
	public void initialize()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium course\\Browser driver\\chromedriver.exe");
		dr=new ChromeDriver();
		dr.get("https://stagesite5-identity.medrio.com/identity/login?signin=e515505840cbf62c00e7ec86c4a47c37");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	@Parameters({"username","password"})
	public void logincheck(String username, String password)
	{
		dr.findElement(By.id("username_")).sendKeys(username);
		dr.findElement(By.id("password")).sendKeys(password);
		dr.findElement(By.id("btnLogin")).click();
		
	}
	
	@Test(priority=2)
	public void titlecheck()
	{
		String title=dr.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=3)
	public void helplink()
	{
		boolean b=dr.findElement(By.linkText("Help")).isDisplayed();
		System.out.println(b);
	}
	
	
	
	@AfterMethod
	public void exit()
	{
		dr.close();
	}
}
