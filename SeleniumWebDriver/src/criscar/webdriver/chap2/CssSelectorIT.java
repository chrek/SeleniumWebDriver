package criscar.webdriver.chap2;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CssSelectorIT {
	
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
    public void byId() throws Exception {
        driver.findElement(By.cssSelector("#change-password"));
    }

    @Test
    public void byClassName() throws Exception {
        driver.findElement(By.cssSelector(".btn"));
    }

    @Test
    public void byName() throws Exception {
        driver.findElement(By.cssSelector("*[name='email']"));
    }

    @Test
    public void byTagName() throws Exception {
        driver.findElement(By.cssSelector("a"));
    }
}
