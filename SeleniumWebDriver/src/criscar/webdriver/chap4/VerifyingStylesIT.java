package criscar.webdriver.chap4;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyingStylesIT {

	// private WebDriver driver;
	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/styled-elements.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void elementHasRedText() throws Exception {
		WebElement element = driver.findElement(By.id("red"));
		assertEquals("rgba(255, 0, 0, 1)", element.getCssValue("color"));
	}

	@Test
	public void cssShortHand() throws Exception {
		WebElement div = driver.findElement(By.id("shorthand"));

		assertEquals("1px solid rgb(0, 0, 0)", div.getCssValue("border"));

		assertEquals("rgb(0, 0, 0)", div.getCssValue("border-color"));
		assertEquals("solid", div.getCssValue("border-style"));
		assertEquals("1px", div.getCssValue("border-width"));
	}
}
