package criscar.webdriver.chap3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseInputIT {
	
	//public String baseUrl = "http://localhost:8080/webdriver/mailing-list.html";
	public String baseUrl = "http://localhost:8080/mailing-list.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void login() throws Exception {
		System.out.println("launching firefox browser");
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);

		driver
		.findElement(By.name("email"))
		.sendKeys("john.doe@swb.com");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Locate and click Check-box
		driver
		.findElement(By.name("terms"))
		.click();
		
		// Locate the submit button
		WebElement sumitButton = driver.findElement(By.tagName("button"));
		
		// Create Actions object (Instance of Actions class) from driver
		Actions act = new Actions(driver);
		
		// Perform the sequence (mouse events operations)
		act.doubleClick(sumitButton).perform();
		
		Thread.sleep(3000);
	
		driver.close();
	}
}
