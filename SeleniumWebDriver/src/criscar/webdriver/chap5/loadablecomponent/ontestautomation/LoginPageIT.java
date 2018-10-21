package criscar.webdriver.chap5.loadablecomponent.ontestautomation;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginPageIT {
	
	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("localhost:8080/registration-form.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void validLoginTest() {

		// Load login page
		LoginPage loginPage = new LoginPage(driver).get();
		
		assertEquals("ParaBank | Welcome | Online Banking", loginPage.loginPageTitle()); 

		// Log in using valid credentials
		//HomePage homePage = loginPage.correctLogin("john", "demo").get();
		
		// Load home page and check welcome text
		//Assert.assertEquals("Welcome John Smith", homePage.getWelcomeString());
	}
	@AfterMethod
	public void closeBrowser() {		
		driver.quit();
	}

}
