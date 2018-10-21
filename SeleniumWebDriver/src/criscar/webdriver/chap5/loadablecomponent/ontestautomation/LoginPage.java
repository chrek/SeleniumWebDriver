package criscar.webdriver.chap5.loadablecomponent.ontestautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPage extends LoadableComponent<LoginPage> {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://parabank.parasoft.com");
	}

	@Override
	protected void isLoaded() throws Error {

		if (!PageLoad.myElementIsClickable(this.driver, By.name("username"))) {
			throw new Error("LoginPage was not successfully loaded");
		}
	}

	@Override
	protected void load() {
	}

	public String loginPageTitle() {

		return driver.getTitle();
	}
}
