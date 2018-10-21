package criscar.webdriver.chap4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ElementIsPresentIT {
	
	public String baseUrl = "http://localhost:8080/styled-elements.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void checkingAnElementIsPresent() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		List<WebElement> elements = driver.findElements(By.id("invisible"));

		assertThat(elements, hasSize(1));
		
		System.out.println("There is(are) " + elements.size() + " element(s) with the same locator");
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
