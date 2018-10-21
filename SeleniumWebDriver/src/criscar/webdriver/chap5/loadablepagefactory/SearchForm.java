package criscar.webdriver.chap5.loadablepagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Path("localhost:8080/search.html")
@Verify(title = "Search", xpath = "//h1[text()='Search']")
public class SearchForm {

	@FindBy(css = "input[name='q']")
	private WebElement query;
	@FindBy(css = "input[type='submit']")
	private WebElement submit;

	public void searchFor(String text) {
		query.sendKeys(text);
		submit.click();
	}
}
