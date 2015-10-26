package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class MainClass extends WebBrowser {
	
	private static SoftAssert softAssert = new SoftAssert();

	public static void getPage(String address) {
		Driver().get(address);
		String title = Driver().getTitle();
		if (title.contains("is not available") || title.contains("Problem loading page")) {
			logger.log(LogStatus.FATAL, title + logger.addScreenCapture(Screenshot.take("FATAL_Cannot_load_page")));
		} else {
			logger.log(LogStatus.PASS, "Redirected to: " + address);
		}
	}

	public static String getCurrUrl() {
		String currAddress = Driver().getCurrentUrl();
		String title = Driver().getTitle();
		if (title.contains("is not available") || title.contains("Problem loading page")) {
			logger.log(LogStatus.FATAL, title + logger.addScreenCapture(Screenshot.take("FATAL_Cannot_load_page")));
		}
		return currAddress;
	}

	public static WebElement getElement(By by) {
		WebDriverWait wait = new WebDriverWait(Driver(), 60);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOf(Driver().findElement(by)));
		} catch (Exception e) {
			System.out.println("Cannot find Element on the page" + e.getMessage());
			logger.log(LogStatus.FAIL, "Cannot find element on the page. Stacktrace: " + e.getStackTrace() + logger
					.addScreenCapture(Screenshot.take("FAIL_Cannot_find_element_" + new Random().nextInt(1000))));
		}
		return element;
	}

	public static void clickOn(By by) {
		WebElement element = getElement(by);
		if (element.isDisplayed() & element.getSize().getHeight() > 0 & element.getSize().getWidth() > 0) {
			element.click();
		} else {
			logger.log(LogStatus.FAIL,
					"Cannot click on element: element is not visible on page or it's dimensions are less then 0"
							+ logger.addScreenCapture(
									Screenshot.take("FAIL_Cannot_click_on_element" + new Random().nextInt(1000))));
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
		logger.log(LogStatus.PASS, "Tab closed");
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

	public static void assertEquals(Object actual, Object expected, String beforeMess) {
		logger.log(LogStatus.INFO, beforeMess);
		if (actual.equals(expected)) {
			logger.log(LogStatus.PASS, "Objects match");
		} else {
			logger.log(LogStatus.FAIL, "Expected: '" + expected + "' Actual: '" + actual + "'"
					+ logger.addScreenCapture(Screenshot.take("FAILED_" + new Random().nextInt(1000))));
			softAssert.assertEquals(actual, expected);
		}
	}

	public static void assertTrue(boolean actual, String beforeMess) {
		logger.log(LogStatus.INFO, beforeMess);
		if (actual) {
			logger.log(LogStatus.PASS, "Objects match");
		} else {
			logger.log(LogStatus.FAIL, "Expected: true, but false"
					+ logger.addScreenCapture(Screenshot.take("FAILED_" + new Random().nextInt(1000))));
			softAssert.assertTrue(actual);
		}
	}

}
