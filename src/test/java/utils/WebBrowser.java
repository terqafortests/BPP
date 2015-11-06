package utils;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.LogStatus;

public class WebBrowser extends ReportManager {

	// ThreadLocal WebDriver variable for executing parallel tests
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	// NOT STATIC WebDriver type variable
	private WebDriver driver = threadLocalDriver.get();

	// Creation of WebDriver method with opportunity to choose browser in .xml
	// file
	@Parameters("browser")	
	@BeforeTest
	public void initWebBrowser(@Optional(value = "Firefox") String browser) {
		startTest(this.getClass().getSimpleName(), "Regression " + browser);
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox has started");
			Logger().log(LogStatus.PASS, "Firefox has started");
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome has started");
			Logger().log(LogStatus.PASS, "Chrome has started");
		} else if (browser.equalsIgnoreCase("Opera")) {
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./src/test/resources/IEDriver.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("FirefoxDisabledCookies")) {
			FirefoxProfile profile = new ProfilesIni().getProfile("default");
			profile.setPreference("network.cookie.cookieBehavior", 2);
			driver = new FirefoxDriver(profile);
		} else if (browser.equalsIgnoreCase("ChromeDisabledCookies")) {
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--disable-local-storage"));
			driver = new ChromeDriver(capabilities);
		} else if (browser.equalsIgnoreCase("IEDisabledCookies")) {
			String command = "REG ADD \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\      \" /v 1A10 /t REG_DWORD /d 0X1 /f";
			try {
				Runtime.getRuntime().exec(command);
				System.setProperty("webdriver.ie.driver", "./src/test/resources/IEDriver.exe");
				driver = new InternetExplorerDriver();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			System.out.println("Browser closed");
			closeTest();
		}
	}

	@AfterSuite
	public void flush() {
		closeReporter();
	}
}
