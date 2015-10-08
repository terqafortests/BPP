package pages;

import org.openqa.selenium.By;

import utils.MainClass;

public class SelectPaperPage extends MainClass {
	
	public static void selectCourse(String courseName) {
		clickOn(By.xpath("//div[@id='myModal']//label[contains(., '" + courseName + "')]"));
	}

}
