package criscar.webdriver.chap2;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LocatorsIT {
	
	//private WebDriver driver;
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
		//driver.close();
	}
	
	@Test
    public void byLinkText() throws Exception {
		System.out.println("Using linkText locator");
        driver.findElement(By.linkText("Forgotten Password"));
    }

    @Test
    public void byPartialLinkText() throws Exception {
    	System.out.println("Using partialLinkText locator");
        driver.findElement(By.partialLinkText("Forgotten Password"));
        driver.findElement(By.partialLinkText("Forgotten "));
        driver.findElement(By.partialLinkText("en Passwo"));
    }

    @Test
    public void byId() throws Exception {
    	System.out.println("Using id locator");
        driver.findElement(By.id("change-password"));
    }

    @Test
    public void byClassName() throws Exception {
    	System.out.println("Using className locator");
        driver.findElement(By.className("btn"));
    }

    @Test
    public void byName() throws Exception {
    	System.out.println("Using name attribute locator");
        driver.findElement(By.name("email"));
    }

    @Test
    public void byTagName() throws Exception {
    	System.out.println("Using tagName locator");
        driver.findElement(By.tagName("a"));
    }

}
