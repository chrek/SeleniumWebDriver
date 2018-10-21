package criscar.webdriver.chap4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PageSourceIT {
	
	public String baseUrl = "http://localhost:8080/styled-elements.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void pageSourceMethod() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);

		System.out.println(driver.getPageSource());
		Thread.sleep(3000);
		
		driver.close();
	}
}
