package pages;

import org.openqa.selenium.By;

import utils.MainClass;

public class MyCalendarPage extends MainClass {
	
	public static By myCalendar = By.xpath("//div[@id='navbarCollapse']//span[contains(text(), 'My Calendar')]");
	public static By helpLink = By.id("forumhelplink");
	public static By exportCalendar = By.xpath(".//*[@id='region-main']/div[4]/div/div/div[3]/div[1]/form/div/input[1]");
	public static By manageSubscription = By.xpath(".//*[@id='region-main']/div[4]/div/div/div[3]/div[2]/form/div/input[1]");
	public static By preferences = By.xpath(".//*[@id='region-main']/div[2]/form/div/input[1]");
	public static By newEvent = By.xpath(".//*[@id='region-main']/div[4]/div/div/div[1]/div[1]/form/div/input[4]");
	public static By detailedViewFor = By.xpath("//label[text()='Detailed month view for:']/following-sibling::select");
	
	
	

}
