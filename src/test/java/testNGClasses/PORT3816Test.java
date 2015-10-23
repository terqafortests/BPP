package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MyProfilePage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3816Test extends MainClass {

	@DataProvider(name = "Check elements")
	public static Object[][] elements() {
		return new Object[][] {{ MyProfilePage.addressLine1, "Address Line1" },
				{ MyProfilePage.addressLine2, "Address Line2" }, { MyProfilePage.addressLine3, "Address Line3" },
				{ MyProfilePage.bppCurrenntID, "BPP Student ID" }, { MyProfilePage.city, "City" },
				{ MyProfilePage.country, "Country" }, { MyProfilePage.name, "Name" },
				{ MyProfilePage.password, "Password" }, { MyProfilePage.postalCode, "Postal Code" },
				{ MyProfilePage.primaryAdress, "Primary Address" }, { MyProfilePage.primaryEmail, "Primary Email" },
				{ MyProfilePage.primaryTelephone, "Primary Telephone" }, { MyProfilePage.state, "State" },
				{ MyProfilePage.username, "Username" } };
	}
	
	@BeforeTest
	public void preCon() {
		LoginPage.login("a.AKSTpLastDQ", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("Regression Test");
		clickOn(SelectPaperPage.open);
		logger.log(LogStatus.PASS, "Clicked on Open button");
		getPage("http://bpp-fusion-test.apolloglobal.int/group/student/my-profile");
	}

	@Test(dataProvider = "Check elements")
	public void port3816Test(By obj, String text) {
		assertEquals(getElementText(obj), text);	
	}
}
