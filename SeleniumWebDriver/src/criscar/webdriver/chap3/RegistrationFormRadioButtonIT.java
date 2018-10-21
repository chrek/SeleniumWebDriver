package criscar.webdriver.chap3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RegistrationFormRadioButtonIT {
	
	public String baseUrl = "http://localhost:8080/registration-form.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void login() throws Exception {
		System.out.println("launching firefox browser");
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		// Locate the radio element with attributes (name="contact" and value="phone")
		// and click on it
		driver
		.findElement(By.cssSelector("input[name='contact'][value='phone']"))
		.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
	
		driver.close();
	}
}
