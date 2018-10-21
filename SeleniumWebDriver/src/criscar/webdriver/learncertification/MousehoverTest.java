package criscar.webdriver.learncertification;

/***************************************
 * 
 *Handle drag and drop-Keyboard and Mouse Events in Selenium Webdriver_learncertification.docx
 * 
 *http://www.learncertification.com/study-material/handle-keyboard-mouse-events-in-selenium-webdriver
 * **************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MousehoverTest {
	
	public String baseUrl = "http://www.learncertification.com/";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
		
	 @Test
	 public void test() {
		 
		 System.out.println("launching firefox browser");
		 
		 System.setProperty("webdriver.gecko.driver", driverPath);
			
		 driver = new FirefoxDriver();
		 driver.get(baseUrl);
		 driver.manage().window().maximize();

		 WebElement parent=driver.findElement(By.id("Login"));
		 WebElement parent2=driver.findElement(By.id("Signup"));

		 Actions builder = new Actions(driver);

		// Mouseover on the LOGIN link
		 Action mouseOver = builder
				 .moveToElement(parent)
				 .build();

		 mouseOver.perform();
		 
		 // Mouseover on the SIGNUP link
		 builder
		 	.moveToElement(parent2)
		 	.build()
		 	.perform();
	}
}
