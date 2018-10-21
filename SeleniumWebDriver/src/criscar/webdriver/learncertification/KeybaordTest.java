package criscar.webdriver.learncertification;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeybaordTest {
	
	public String baseUrl = "http://www.learncertification.com/";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void test() {
		
		System.out.println("launching firefox browser");
		 
		 System.setProperty("webdriver.gecko.driver", driverPath);

	 driver = new FirefoxDriver();
	 driver.manage().window().maximize();

	 driver.get(baseUrl);

	 WebElement searchbox = driver.findElement(By.id("search_course"));

	 searchbox.sendKeys("ANDROID");

	 //enter key passed by two ways

	//  searchbox.sendKeys(Keys.RETURN); or

	// searchbox.sendKeys(Keys.ENTER);

	 // or using Actions class

	 Actions action = new Actions(driver); 

	 //action.sendKeys(driver.findElement(By.id("search_course")), Keys.ENTER).build().perform();
	 action.sendKeys(searchbox, Keys.ENTER).build().perform();
	 // locate and click the "Android Application Development  AND-401" link
	 WebElement el = driver.findElement(By.linkText("Android Application Development  AND-401"));

	 el.click();

	}


}
