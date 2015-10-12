package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass extends WebBrowser {
	
	public static void getPage(String address) {
		Driver().get(address);
	}
	
	public static String getCurrUrl() {
		return Driver().getCurrentUrl();
	}
	
	public static WebElement getElement(By by) {
		WebDriverWait wait = new WebDriverWait(Driver(), 60);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOf(Driver().findElement(by)));
			return element;
		} catch (NoSuchElementException e) {
			System.out.println("Cannot find Element on the page" + e.getStackTrace());
		}
		return element;
	}
	
	public static void clickOn(By by) {
		WebElement element = getElement(by);
		if (element.isDisplayed()){
			element.click();
		} else {
			System.out.println("Element is not displayed on the page");
		}
	}
	
	public static void enterText(By by, String text) {
		WebElement element = getElement(by);
		element.clear();
		element.sendKeys(text);		
	}
	
	public static void switchToFrame(String frameId) {
		try {
		Driver().switchTo().frame(frameId);
		} catch (Exception e) {
			System.out.println("Cannot switch to frame " + frameId);
			Driver().switchTo().frame(frameId);
		}
	}
	
	public static void sleepFor(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver switchToTab(int i) {
		return Driver().switchTo().window(getTabs().get(i));
	}

	public static List<String> getTabs() {
		List<String> windows = new ArrayList<String>(Driver().getWindowHandles());
		return windows;
	}
	
	public static void closeTab(int i) {
		switchToTab(i).close();
	}
	
	public static String getElementAtt (By by, String attName) {
		return getElement(by).getAttribute(attName);
	}
	
	public static String getElementText (By by) {
		return getElement(by).getText();
	}
	
	public static void switchToDefaultFrame() {
		Driver().switchTo().defaultContent();
	}
	
	public static List<WebElement> getElements(By by) {
		return Driver().findElements(by);
		
	}
}
