package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class MainClass extends WebBrowser {

	public static void getPage(String address) {
		Driver().get(address);
		logger.log(LogStatus.PASS, "Redirected to page: " + address);
	}

	public static String getCurrUrl() {
		String currAddress = Driver().getCurrentUrl();
		logger.log(LogStatus.INFO, "Current URL is: " + currAddress);
		return currAddress;
	}

	public static WebElement getElement(By by) {
		WebDriverWait wait = new WebDriverWait(Driver(), 60);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOf(Driver().findElement(by)));
		} catch (NoSuchElementException e) {
			System.out.println("Cannot find Element on the page" + e.getStackTrace());
			logger.log(LogStatus.FAIL, "Cannot find element on the page. Stacktrace: " + e.getStackTrace());
		}
		return element;
	}

	public static void clickOn(By by) {
		WebElement element = getElement(by);
		if (element.isDisplayed() & element.getSize().getHeight() > 0 & element.getSize().getWidth() > 0) {
			element.click();
		} else {
			logger.log(LogStatus.FAIL,
					"Cannot click on element: element is not visible on page or it's dimensions are less then 0");
		}
	}

	public static void enterText(By by, String text) {
		WebElement element = getElement(by);
		element.clear();
		element.sendKeys(text);
		logger.log(LogStatus.PASS, "Entered text: " + text);
	}

	public static void switchToFrame(String frameId) {
		try {
			Driver().switchTo().frame(frameId);
		} catch (Exception e) {
			System.out.println("Cannot switch to frame " + frameId);
			Driver().switchTo().frame(frameId);
			logger.log(LogStatus.FAIL, "Cannot swith to frame: " + frameId);
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
		WebDriver tab = null;
		try {
			tab = Driver().switchTo().window(getTabs().get(i));
			logger.log(LogStatus.PASS, "Switched to tab " + tab.getTitle());
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Cannot switch to tab");
		}
		return tab;
	}

	public static List<String> getTabs() {
		List<String> windows = new ArrayList<String>(Driver().getWindowHandles());
		return windows;
	}

	public static void closeTab(int i) {
		switchToTab(i).close();
		logger.log(LogStatus.FAIL, "Tab closed");
	}

	public static String getElementAtt(By by, String attName) {
		return getElement(by).getAttribute(attName);
	}

	public static String getElementText(By by) {
		return getElement(by).getText();
	}

	public static void switchToDefaultFrame() {
		Driver().switchTo().defaultContent();
		logger.log(LogStatus.PASS, "Switched to default frame");
	}

	public static List<WebElement> getElements(By by) {
		return Driver().findElements(by);
	}
	
	public static void assertEquals(Object actual, Object expected) {
		logger.log(LogStatus.INFO, "Trying to compare object with " + expected);
		if(actual.equals(expected)){
			logger.log(LogStatus.PASS, "Objects match");
		} else {
			logger.log(LogStatus.FAIL, "Expected: '" + expected + "' Actual: '" + actual + "'");
			Assert.assertEquals(actual, expected);
		}
	}
	
}
