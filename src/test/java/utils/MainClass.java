package utils;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainClass extends WebBrowser {
	
	public static WebElement getElement(By by) {
		WebElement element = null;
		try {
			element = Driver().findElement(by);
			return element;
		} catch (NoSuchElementException e) {
			System.out.println("Cannot find Element on the page" + e.getStackTrace());
		}
		return element;
	}

}
