package testNGClasses;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.HeaderPage;
import pages.LoginPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3834InvAddressTest extends MainClass {

	@DataProvider(name = "Check elements")
	public static Object[][] elements() {
		return new Object[][] {
				{ "http://bpp-fusion-test.apolloglobal.int/group/sadfsadfsf",
						By.xpath(".//*[@id='p_p_id_webContent_WAR_wp_INSTANCE_lRk9ZHauzVPb_']/div/div/div") },
				{ "http://bpp-fusion-test.apolloglobal.int/group/bizops",
						By.xpath(".//*[@id='p_p_id_webContent_WAR_wp_INSTANCE_lRk9ZHauzVPb_']/div/div/div") } };
	}

	@BeforeTest
	public void preCon() {
		LoginPage.login("BP5032875", "Ak081915");
		switchToFrame(HeaderPage.iFrame);
		SelectPaperPage.selectCourse("My Super Course");
		clickOn(SelectPaperPage.open);
		logger.log(LogStatus.PASS, "Clicked on Open button");
	}

	@Test(dataProvider = "Check elements")
	public void port3834InvDataTest(String address, By obj) {
		getPage(address);
		assertEquals(getElementText(obj),
				"The content in this no-permission page can be managed by the content admin user.",
				"Verifying if actual message equals: The content in this no-permission page can be managed by the content admin user.");
	}
}
