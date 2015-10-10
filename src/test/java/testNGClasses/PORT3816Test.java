package testNGClasses;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyLearningPage;
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
  }
}
