package criscar.webdriver.chap3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class KeyboardInputIT {
	
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
		
		//Selecting the Checkbox: Locate element and use the Actions() 
		//Class to select checkbox
		//Instance of Actions class
		Actions act = new Actions(driver);
		
		Thread.sleep(3000);
	/*	
		//Keyboard events operations
		act.sendKeys(Keys.TAB);
		
		Thread.sleep(3000);
		
		driver
		.switchTo().activeElement()
		.sendKeys(" ");
		System.out.println("Ok 2");		
*/
		//Get Check-box
		//WebElement checkbox=driver.findElement(By.id("subscribeNews"));
		
		WebElement checkbox=driver.findElement(By.name("terms"));
		//act.sendKeys(checkbox, Keys.ENTER).build().perform();	//Ok
		act.sendKeys(checkbox, Keys.LEFT).build().perform(); //ok

		driver.close();
		driver.quit();
	}
}
