package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebBrowser {

	// ThreadLocal WebDriver variable for executing parallel tests
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	// NOT STATIC WebDriver type variable
	private WebDriver driver = threadLocalDriver.get();

	// Creation of WebDriver method with opportunity to choose browser in .xml
	// file
	@Parameters("browser")
	@BeforeTest
	public void initWebBrowser(@Optional(value = "Chrome") String browser) {

		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Opera")) {
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		threadLocalDriver.set(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// Get driver method
	public static WebDriver Driver() {
		return threadLocalDriver.get();
	}

	// Close driver method with killing ThreadLocal variable of WebDriver after
	// tests
	@AfterTest
	public void closeWebBrowser() {
		if (driver != null) {
			driver.quit();
			threadLocalDriver.remove();
		}
	}
}
