package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebBrowser extends ReportManager {

	// ThreadLocal WebDriver variable for executing parallel tests
	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

	// NOT STATIC WebDriver type variable
	private WebDriver driver = threadLocalDriver.get();

	private ExtentReports extent = ReportManager.getInstance();

	public static ExtentTest logger;

	// Creation of WebDriver method with opportunity to choose browser in .xml
	// file
	@Parameters("browser")
	@BeforeTest
	public void initWebBrowser(@Optional(value = "Firefox") String browser) {
		logger = extent.startTest(this.getClass().getSimpleName());
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox opened");
			logger.log(LogStatus.INFO, "Firefox has started");
		} else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sshept4teco\\workspace\\BPP\\src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.log(LogStatus.INFO, "Chrome has started");
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
			System.out.println("Browser closed");
			logger.log(LogStatus.INFO, "Browser closed");
			extent.endTest(logger);
		}		
	}

	@AfterSuite
	public void flush() {
		extent.flush();
	}
}
