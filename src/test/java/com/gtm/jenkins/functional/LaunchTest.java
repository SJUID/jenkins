package com.gtm.jenkins.functional;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchTest {

	public static WebDriver driver = null;
	
	@BeforeAll
	public static void initialisation(){
		
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterAll
	public static void finalisation() {
		
		driver.close();
		
		driver = null;
	}
	
	@BeforeEach
	public void openWebBrowser() {
		
		driver.navigate().to("https://unsplash.com/");
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkTitleTest() {
		
		String title = driver.getTitle();
		
		String titleExpected = "Beautiful Free Images & Pictures | Unsplash";

		Assertions.assertEquals(titleExpected, title);
		
	}
	
	@Test
	public void checkElementTest() {

		String elementName = driver.findElement(By.cssSelector("span")).getText();
		
		String elementNameExpected = "Unsplash";
				
		Assertions.assertEquals(elementNameExpected, elementName);
		
	}
}
