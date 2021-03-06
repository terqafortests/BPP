package pages;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;
import utils.MainClass;

public class SelectPaperPage extends MainClass {
		
	public static By open = By.id("open_button");
	public static By logout = By.id("logout_button");
	public static By messageArea = By.cssSelector("#myModal p");
	public static By needHelp = By.linkText("Need Help");
	
	public static void selectCourse(String courseName) {
		clickOn(By.xpath("//div[@id='myModal']//label[contains(., '" + courseName + "')]"));
		Logger().log(LogStatus.PASS, "Selected course: " + courseName);
	}

}
