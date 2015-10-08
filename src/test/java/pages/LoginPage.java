package pages;

import org.openqa.selenium.By;
import utils.MainClass;

/**
 * Created by roma on 10/8/15.
 */
public class LoginPage extends MainClass {

    public static By username = By.id("username");
    public static By password = By.id("password");
    public static By submit = By.name("submit");


    public void login(String user, String pass) {
        getPage("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
        enterText(username, user);
        enterText(password, pass);
        clickOn(submit);
    }

}
