package testNGClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyGroupsPage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3863MyGrHelpTest3 extends MainClass {
	@Test
	public void port3863MyGrHelpTest3Test() {
		LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(SelectPaperPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		switchToDefaultFrame();
		clickOn(MyGroupsPage.myGroups);
		switchToFrame(SelectPaperPage.iFrame);
		clickOn(MyGroupsPage.helpLink);
		switchToTab(1);
		Assert.assertEquals(getCurrUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student/help#MyGroups");
	}
}
