package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;
import utils.Screenshot;

public class NewTest1 extends MainClass {
  @Test
  public void f() {
	  logger.log(LogStatus.INFO, "Info1");
	  getPage("http://google.com");
	  logger.log(LogStatus.INFO, "success: " + logger.addScreenCapture(Screenshot.take("qwe")));
	  System.out.println("Hello World");
	  clickOn(By.xpath("//*[@id='ts']/div[2]/div[3]/center/input[1]"));
	  logger.log(LogStatus.PASS, "Test Passed");
  }
}
