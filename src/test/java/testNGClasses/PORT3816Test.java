package testNGClasses;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyLearningPage;
import pages.MyProfilePage;
import pages.SelectPaperPage;
import utils.MainClass;

public class PORT3816Test extends MainClass {
  @Test
  public void port3816Test() {
	  LoginPage.login("BP5003200", "Gr091714");
		switchToFrame(SelectPaperPage.iFrame);
		SelectPaperPage.selectCourse("Roma Test Course 1");
		clickOn(SelectPaperPage.open);
		switchToDefaultFrame();
		clickOn(MyLearningPage.userDropdown);
		clickOn(MyLearningPage.myProfile);
		ArrayList<String> infoTable = MyProfilePage.getTableData(MyProfilePage.myProfTable);
		Assert.assertEquals(infoTable.size(), 28);
		for (String e: infoTable) {
			Assert.assertTrue(e.length() >= 0);
		}
  }
}
