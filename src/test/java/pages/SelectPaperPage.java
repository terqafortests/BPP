package pages;

import org.openqa.selenium.By;

import utils.MainClass;

public class SelectPaperPage extends MainClass {
	
	public static By open = By.id("open_button");
	public static By logout = By.id("logout_button");
	public static By messageArea = By.cssSelector("#myModal p");
	
	public static void selectCourse(String courseName) {
		clickOn(By.xpath("//div[@id='myModal']//label[contains(., '" + courseName + "')]"));
	}

}
