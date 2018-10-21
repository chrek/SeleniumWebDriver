package criscar.webdriver.chap3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginIT {
	
	//public String baseUrl = "http://localhost:8080/webdriver/login.html";
	public String baseUrl = "http://localhost:8080/login.html";
	
	//String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	String driverPath = "geckodriver.exe";//file at root of project 
	
	public WebDriver driver;
	
	@Test
	public void login() throws Exception {
		System.out.println("launching firefox browser");
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		WebElement email = driver.findElement(By.name("email"));
		email.clear();
		email.sendKeys("john@doe.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("secret");
		driver.findElement(By.cssSelector("input[type='submit']"))
			.click();
	}
}
