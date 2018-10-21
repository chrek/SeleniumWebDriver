package criscar.webdriver.chap5.pagefactory;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchFormIT {

	public String baseUrl = "http://localhost:8080/search.html";

	String driverPath = "geckodriver.exe";// file at root of the project

	private WebDriver driver;

	@Test
	public void pageFactory() throws Exception {
		System.out.println("launching firefox browser");

		System.setProperty("webdriver.gecko.driver", driverPath);

		driver = new FirefoxDriver();
		driver.get(baseUrl);

		// Create an instance of the Page object with the
		// WebDriver driver as argument
		SearchForm searchForm = PageFactory.initElements(driver, SearchForm.class);

		// Call the searchFor method with the text to search as argument
		searchForm.searchFor("funny cats");
	}
}
