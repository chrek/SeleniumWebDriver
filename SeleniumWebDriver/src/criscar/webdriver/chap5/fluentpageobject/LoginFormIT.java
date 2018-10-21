package criscar.webdriver.chap5.fluentpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginFormIT {

	public String baseUrl = "http://localhost:8080/login.html";

	String driverPath = "geckodriver.exe";// file at root of the project

	private WebDriver driver;

	@Test
	public void checkLoginForm() throws Exception {
		System.out.println("launching firefox browser");

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();
		driver.get(baseUrl);

		// Create an instance of the Page object with the
		// WebElement loginForm element locator as argument
		LoginForm loginForm = new LoginForm(driver.findElement(By.id("login")));

		// Set the user name
		loginForm.username("jdoe@inland.com");
		
		// Set password
		loginForm.password("jdoe123");
		
		//Submit Form
		loginForm.submit();
		
		new WebDriverWait(driver, 2).until((WebDriver input) -> "You Are Logged In".equals(driver.getTitle()));
	}
}
