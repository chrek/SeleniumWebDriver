package criscar.webdriver.chap2.locatorfactory;

import org.openqa.selenium.By;

public final class ElementBy {

	private ElementBy() {
	}

	public static By partialText(String text) {
		return By.xpath("//*[contains(normalize-space(.), '" + text + "')]");
	}
}
