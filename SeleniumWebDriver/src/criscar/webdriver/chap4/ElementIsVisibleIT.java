package criscar.webdriver.chap4;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ElementIsVisibleIT {
	
	public String baseUrl = "http://localhost:8080/styled-elements.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void visibleElementIsDisplayed() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		WebElement element = driver.findElement(By.id("visible"));

		assertTrue(element.isDisplayed());
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
