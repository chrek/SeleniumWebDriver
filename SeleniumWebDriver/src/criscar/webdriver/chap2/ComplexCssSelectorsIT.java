package criscar.webdriver.chap2;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ComplexCssSelectorsIT {
	
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
    public void singleAttribute() throws Exception {
        driver.findElement(By.cssSelector("input[name='email']"));
    }

    @Test
    public void multipleAttributes() throws Exception {
        driver.findElement(By.cssSelector("input[type='text'][name='email']"));
    }

    @Test
    public void attributePrefix() throws Exception {
        driver.findElement(By.cssSelector("input[name^='pass']"));
    }

    @Test
    public void attributeSuffix() throws Exception {
        driver.findElement(By.cssSelector("input[name$='word']"));
    }

    @Test
    public void attributeInfix() throws Exception {
        driver.findElement(By.cssSelector("input[name*='sswo']"));
    }

    @Ignore("page changed layout")
    @Test
    public void sibling() throws Exception {
        driver.findElement(By.cssSelector("input[name='password'] + input[type='submit']"));
    }

    @Ignore("page changed layout")
    @Test
    public void looseSibling() throws Exception {
        driver.findElement(By.cssSelector("input[name='email'] ~ input[type='submit']"));
    }

    @Test
    public void directDescendant() throws Exception {
        driver.findElement(By.cssSelector("div > input[name='email']"));
    }

    @Test
    public void anyDescendant() throws Exception {
        driver.findElement(By.cssSelector("form input[name='email']"));
    }

}
