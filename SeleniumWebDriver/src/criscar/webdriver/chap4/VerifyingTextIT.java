package criscar.webdriver.chap4;

import static org.testng.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VerifyingTextIT {
	
	public String baseUrl = "http://localhost:8080/styled-elements.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void xpathTextMethod() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);

		//assertNotNull(driver.findElement(By.xpath("//*[text()='A visible paragraph.']")));
		//assertNotNull(driver.findElement(By.xpath("//p[@id='visible']")));
		//assertNotNull(driver.findElement(By.id("visible")));
		assertNotNull(driver.findElement(By.cssSelector("#visible")));
		
		
		
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
