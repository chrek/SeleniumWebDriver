package criscar.webdriver.inviul;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyboardEventsOperations {
	
	@Test
	  public void keyboardEventsOperations() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\myProject\\chromedriver\\chromedriver.exe");
	   
	   WebDriver driver = new ChromeDriver();
	   
	   String expectedText = "SELENIUM";
	 
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   driver.get("http://www.inviul.com");
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   WebElement dbl = driver.findElement(By.xpath("//*[@id='s']"));
	   Thread.sleep(3000);
	   
	   //Instance of Actions class
	   Actions act = new Actions(driver);
	   
	   //Keyboard events operations
	   act.sendKeys(dbl, Keys.SHIFT, "selenium").build().perform();
	   
	   Thread.sleep(3000);
	   
	   String actualText = dbl.getAttribute("value");
	   
	   Assert.assertEquals(actualText, expectedText);
	   
	   driver.close();
	   
	   driver.quit();
	  }

}
