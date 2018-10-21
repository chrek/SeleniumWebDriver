package criscar.webdriver.chap5.loadablecomponent;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SearchForm extends LoadableComponent<SearchForm> {

	private WebDriver driver;

	public SearchForm(WebDriver driver) {
		this.driver = driver;
		driver.get("http://localhost:8080/search.html");
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {
		System.out.println("In isLoaded() method");
		assertEquals("Search", driver.getTitle());
	}

	public void searchFor(String query) {
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys(query);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
}
