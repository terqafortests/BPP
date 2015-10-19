package pages;

import org.openqa.selenium.By;
import utils.MainClass;

public class MyProfilePage extends MainClass {
		
	public static By name = By.xpath("//*[@id='generalSettingsForm']//th[text()='Name']");
	public static By username = By.xpath("//*[@id='generalSettingsForm']//th[text()='Username']");
	public static By password = By.xpath("//*[@id='generalSettingsForm']//th[text()='Password']");
	public static By bppCurrenntID = By.xpath("//*[@id='generalSettingsForm']//th[text()='BPP Student ID']");
	public static By primaryEmail = By.xpath("//*[@id='generalSettingsForm']//th[text()='Primary Email']");
	public static By primaryTelephone = By.xpath("//*[@id='generalSettingsForm']//th[text()='Primary Telephone']");
	public static By primaryAdress = By.xpath("//*[@id='generalSettingsForm']//th[text()='Primary Address']");
	public static By addressLine1 = By.xpath("//*[@id='generalSettingsForm']//th[text()='Address Line1']");
	public static By addressLine2 = By.xpath("//*[@id='generalSettingsForm']//th[text()='Address Line2']");
	public static By addressLine3 = By.xpath("//*[@id='generalSettingsForm']//th[text()='Address Line3']");
	public static By city = By.xpath("//*[@id='generalSettingsForm']//th[text()='City']");
	public static By state = By.xpath("//*[@id='generalSettingsForm']//th[text()='State']");
	public static By country = By.xpath("//*[@id='generalSettingsForm']//th[text()='Country']");
	public static By postalCode = By.xpath("//*[@id='generalSettingsForm']//th[text()='Postal Code']");
}
