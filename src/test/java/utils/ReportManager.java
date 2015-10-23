package utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportManager {
	
	private static ExtentReports extent;
	
	 public static ExtentReports getInstance() {
	        if (extent == null) {
	            extent = new ExtentReports("./Report.html", true);
	            
	            // optional
	            extent.config()
	                .documentTitle("Automation Report")
	                .reportName("Regression")
	                .reportHeadline("");
	               
	            // optional
	            extent
	                .addSystemInfo("Selenium Version", "2.46")
	                .addSystemInfo("Environment", "QA");
	        }
	        return extent;
	    }
	 
}
