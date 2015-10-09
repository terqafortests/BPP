package pages;

import org.openqa.selenium.By;

import utils.MainClass;

public class MyCalendarPage extends MainClass {
	
	public static By myCalendar = By.xpath("//div[@id='navbarCollapse']//span[contains(text(), 'My Calendar')]");
	public static By helpLink = By.id("forumhelplink");

}
