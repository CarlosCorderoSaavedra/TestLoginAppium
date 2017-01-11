package appium.tutorial.android.page;

import static appium.tutorial.android.util.Helpers.find;

/** Page object for the accessibility page **/
public abstract class UserLoggedPage {

    /** Verify the accessibility page has loaded **/
    public static void loaded() {
        find("Hi, User1");
    }
}