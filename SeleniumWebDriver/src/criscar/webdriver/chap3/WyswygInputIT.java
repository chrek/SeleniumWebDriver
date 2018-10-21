package criscar.webdriver.chap3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyswygInputIT {
	// String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	String driverPath = "chromedriver.exe";// file at root of project

	// private WebDriver driver;
	static WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/wyswyg-editor.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void enterTextIntoAWyswgyEditor() throws Exception {

		WebElement editorFrame = driver.findElement(By.id("editor_ifr")); // #1 find the correct iframe

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body")); // #2 get the body element

		body.clear(); // #3 clear the existing text
		body.sendKeys("A paragraph of text, some of which is"); // #4 send our un-formatted text

		driver.switchTo().defaultContent(); // #5 switch back to the original frame
		driver.findElement(By.className("mce-i-italic")).click(); // #6 click the italic button
		Thread.sleep(5000);
		driver.switchTo().frame(editorFrame); // #7 switch back to the editor
		body.sendKeys(" italics."); // #8 type italic text

		driver.switchTo().defaultContent();
		driver.findElement(By.className("mce-i-italic")).click(); // #9 deselect italics
	}
}
