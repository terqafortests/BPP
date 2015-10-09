package pages;

import org.openqa.selenium.By;

import utils.MainClass;

public class MyGroupsPage extends MainClass {
	
	public static By myGroups = By.xpath("//div[@id='navbarCollapse']//span[contains(text(), 'My Groups')]");
	public static By mainContent = By.xpath("//div[@role='main']//p");

}
