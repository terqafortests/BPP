package testNGClasses;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class PORT3855Test extends MainClass {

	@BeforeTest
	public void preCon() {
		LoginPage.login("BP5032875", "Ak081915");
		
	}

	@Test
	public void port3855Test() {
		ArrayList<String> string = new ArrayList<String>();
		ArrayList<String> string1 = new ArrayList<String>();
		switchToFrame(HeaderPage.iFrame);
		List<WebElement> courseList = getElements(By.xpath("//div[@id='myModal']//label"));		
		for (WebElement e: courseList) {			
			string.add(e.getText());
		}
		Logger().log(LogStatus.PASS, "Course list from papers page is got");
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		Logger().log(LogStatus.PASS, "Clicked on login button");
		List<WebElement> courseList2 = getElements(By.xpath("//select[@name='select_course']/option[@value != '0']"));
		for (WebElement e: courseList2) {			
			string1.add(e.getText());
		}
		Logger().log(LogStatus.PASS, "Course list from learning page is got");
		assertEquals(string, string1, "Verifying if courses list match");
	}

}
