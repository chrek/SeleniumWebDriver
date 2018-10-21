package criscar.webdriver.chap2;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChainedLocatorsIT {

	// private WebDriver driver;
	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/login.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void chainedLocators() throws Exception {
		driver.findElement(By.className("forgotten-password")).findElement(By.tagName("a"));
	}

	@Test
	public void chainedStreamLocators() throws Exception {
		driver.findElements(By.tagName("a")).stream().filter(e -> e.getText().contains("Forgotten Password"))
				.findFirst().get();
	}

	@Test
	@SuppressWarnings("unused")
	public void chainedFormLocators() throws Exception {
		WebElement loginForm = driver.findElement(By.id("login")); // #1 locate the form itself
		WebElement emailInput = loginForm.findElement(By.name("email")); // #2 narrow down each element
		WebElement passwordInput = loginForm.findElement(By.name("password"));
		WebElement submit = loginForm.findElement(By.className("btn-primary"));
	}

}
