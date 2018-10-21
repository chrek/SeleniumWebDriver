package criscar.webdriver.chap2;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByChained;

import criscar.webdriver.chap2.locatorfactory.AllBy;
import criscar.webdriver.chap2.locatorfactory.AnyBy;
import criscar.webdriver.chap2.locatorfactory.NotBy;

public class LocatorCompositionIT {

	// private WebDriver driver;
	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/registration-form.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void byChained() throws Exception {
		driver.findElement(new ByChained(By.id("registration-form"), By.xpath("//label[contains(.,'Email')]"),
				By.tagName("input")));
	}

	@Test
	public void byIdOrName() throws Exception {
		driver.findElement(new ByIdOrName("password"));
	}

	@Test
	public void byAnd() throws Exception {
		assertEquals("password",
				driver.findElement(AllBy.all(By.tagName("input"), By.name("password"))).getAttribute("name"));
	}

	@Test
	public void byAny() throws Exception {
		assertEquals("email", driver.findElement(AnyBy.any(By.id("email"), By.name("email"))).getAttribute("name"));
	}

	@Test
	public void byExcludes() throws Exception {
		assertEquals("phone",
				driver.findElements(AllBy.all(By.name("contact"), NotBy.not(By.cssSelector("*[value='email']")))).get(0)
						.getAttribute("value"));
	}

}
