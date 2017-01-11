package appium.tutorial.android.page;

import static appium.tutorial.android.util.Helpers.driver;
import static appium.tutorial.android.util.Helpers.find;

/** Page object for the home page **/
public abstract class LoginPage {

    /** Verify the home page has loaded.
     *  Click the accessibility button.
     *  Verify the accessibility page has loaded. **/
    public static void signInClick() {

        String mailButtonId = "com.cabify.qabify:id/email";
        String passwordButtonId = "com.cabify.qabify:id/password";
        String loginButtonId = "com.cabify.qabify:id/email_sign_in_button";
        String userOnePassword = "password";
        String userOneEmail = "user1@example.com";


        loaded();
        driver.findElementById(loginButtonId).click();
        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(loginButtonId).click();

        UserLoggedPage.loaded();
    }



    /** Verify the home page has loaded **/
    public static void loaded() {
        find("QAbify");
    }
}