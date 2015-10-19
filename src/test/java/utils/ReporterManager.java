package utils;

import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReporterManager {
	
	public static ExtentReports reporter;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void initLogger() {
		reporter = new ExtentReports("C:\\Users\\sshept4teco\\workspace\\BPP\\Report.html", false);
		logger = reporter.startTest(getClass().getSimpleName());
		}
}
