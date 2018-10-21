package criscar.webdriver.chap5.fluentpageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginForm {

	private final WebElement loginForm;

	public LoginForm(WebElement loginForm) {
		super();
		this.loginForm = loginForm;
	}

	public LoginForm username(String email) {
		loginForm.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		return this;
	}
	
	public LoginForm password(String password) {
		loginForm.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		return this;
	}
	
	public void submit() {
		loginForm.findElement(By.cssSelector("input[type='submit']")).click();
	}
}
