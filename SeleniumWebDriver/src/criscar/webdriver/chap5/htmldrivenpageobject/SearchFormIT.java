package criscar.webdriver.chap5.htmldrivenpageobject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchFormIT {

	public String baseUrl = "http://localhost:8080/search.html";

	String driverPath = "geckodriver.exe";// file at root of the project

	private WebDriver driver;

	@Test
	public void search() throws Exception {
		System.out.println("launching firefox browser");

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();
		driver.get(baseUrl);

		// Create an instance of the Page object with the
		// WebDriver driver as argument
		SearchForm searchForm = new SearchForm(driver);

		// Call the setQuery method with the text to search as argument
		searchForm.setQuery("funny cats");
		
		Thread.sleep(5000);
		//Submit Form
		searchForm.submit();		
	}
}
