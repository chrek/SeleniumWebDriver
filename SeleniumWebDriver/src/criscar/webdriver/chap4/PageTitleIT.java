package criscar.webdriver.chap4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PageTitleIT {
	
	//public String baseUrl = "http://localhost:8080/styled-elements.html";
	public String baseUrl = "http://localhost:8080/mailing-list.html";
	String driverPath = "D:\\myProject\\Firefox\\geckodriver.exe";
	
	public WebDriver driver;
	
	@Test
	public void checkThePageTitle() throws Exception {
		
		System.out.println("launching firefox browser");		
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		driver = new FirefoxDriver();
		driver.get(baseUrl);

		assertThat(driver.getTitle(), containsString("Styled Elements"));
		Thread.sleep(3000);
		
		driver.close();
	}
}
