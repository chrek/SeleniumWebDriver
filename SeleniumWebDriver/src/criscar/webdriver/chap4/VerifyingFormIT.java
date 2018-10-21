package criscar.webdriver.chap4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class VerifyingFormIT {
	
	public String baseUrl = "http://localhost:8080/pre-filled-form.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void xpathTextMethod() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
		// Textbox input
		// To check a field’s value, you can get the value attribute:
		assertEquals("john.doe@swb.com", driver.findElement(By.name("email")).getAttribute("value"));


		// Password input
		// Use the same techniques as for text inputs:
		assertEquals("secret",
		driver.findElement(By.name("password")).getAttribute("value"));

		// TextArea
		// Text areas don’t have a value attribute. Instead, you examine their text:
		assertEquals("Tell us what you think.",
		driver.findElement(By.name("comments")).getText());

		// Check boxes and radio buttons
		// Check boxes and radio buttons can be verified using the WebElement.isSelected method:
		assertTrue(driver.findElement(By.cssSelector("input[name='contact'][value='phone']")).isSelected());
		
		// Select drop-downs
		// Wrap select drop-down using the Select class. 
		// To check one option, use the getFirstSelectedOption method:
		Select hearAboutSelect = new Select(driver.findElement(By.name("hearAbout")));
		assertEquals("Friend", hearAboutSelect.getFirstSelectedOption().getText());

		// To check multiple options, use getAllSelectedOptions, but you’ll want to extract the selected text:
		WebElement interestsElement = driver.findElement(By.name("interest"));
		List<String> selectedText = new ArrayList<>();
		for (WebElement option : new Select(interestsElement).getAllSelectedOptions()) {
			selectedText.add(option.getText());
		}
		
		Collections.sort(selectedText);
		assertEquals(Arrays.asList("Movies", "Music"), selectedText);		
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
