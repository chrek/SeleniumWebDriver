package criscar.webdriver.chap3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContextMenuIT {

	public static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("launching browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/context-menu.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void login() throws Exception {

		// Locate element with context-menu
		WebElement contextMenu = driver.findElement(By.id("hascontextmenu"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create Actions object (Instance of Actions class) from driver
		Actions act = new Actions(driver);

		// Perform the sequence (right-click for context-menu operations)
		act.contextClick(contextMenu).perform();

		Thread.sleep(3000);
	}
	
	@Test
	public void selectOption() throws Exception {
		// Locate element with context-menu
		WebElement contextMenu = driver.findElement(By.id("hascontextmenu"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create Actions object (Instance of Actions class) from driver
		Actions act = new Actions(driver);		
		
		// Perform the sequence (right-click for context-menu operations)
		// Then select the Faceplus link/option (2nd option)
		act.contextClick(contextMenu).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build()
				.perform();
	}
}
