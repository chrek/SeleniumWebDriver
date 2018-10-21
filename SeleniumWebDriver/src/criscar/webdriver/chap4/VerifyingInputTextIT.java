package criscar.webdriver.chap4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyingInputTextIT {
	
	public String baseUrl = "http://localhost:8080/styled-elements.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void inputShouldHaveInputText() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);

		assertThat(driver.findElement(By.name("text")).getAttribute("value"), equalTo("Input text"));	
				
		Thread.sleep(3000);
		
		driver.close();
	}
}
