package criscar.webdriver.chap2;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableIT {

	// private WebDriver driver;
	static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("localhost:8080/users-table.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		// driver.close();
	}

	@Test
	public void findCell() throws Exception {
		int columnNumber = 1;
		while (!driver.findElement(By.cssSelector(String.format("table#users-table th:nth-child(%d)", columnNumber)))
				.getText().equals("Name")) {
			columnNumber++;
		}
		assertEquals("John Doe",
				driver.findElement(By.cssSelector(
						String.format("table#users-table tbody tr:nth-child(1) td:nth-child(%d)", columnNumber)))
						.getText());

	}

	@Test
	public void columnNumberLocator() throws Exception {

		int columnNumber = new ColumnNumberFinder(driver.findElement(By.cssSelector("table#users-table"))).find("Name");

		driver.findElement(By
				.cssSelector(String.format("table#users-table tbody tr:nth-child(1) td:nth-child(%d)", columnNumber)));
	}

	@Test
	public void classicCssSelector() throws Exception {
		assertEquals("John Doe", driver
				.findElement(By.cssSelector("table#users-table tbody tr:nth-child(1) td:nth-child(3)")).getText());
	}

	@Test
	public void classicXpathQuery() throws Exception {
		assertEquals("John Doe",
				driver.findElement(By.xpath("//table[@id='users-table']/tbody/tr[1]/td[3]")).getText());
	}

}
