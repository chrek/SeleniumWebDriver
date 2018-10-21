package criscar.webdriver.chap4;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ElementIsNotVisibleIT {
	
	public String baseUrl = "http://localhost:8080/styled-elements.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void invisibleElementIsNotDisplayed() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		assertFalse(driver.findElement(By.id("invisible")).isDisplayed());
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
