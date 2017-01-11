package appium.tutorial.android;

import appium.tutorial.android.page.LoginPage;
import appium.tutorial.android.util.AppiumTest;

import static appium.tutorial.android.util.Helpers.back;

public class PageObjectPatternTest extends AppiumTest {

    @org.junit.Test
    public void pageObject() throws Exception {
        LoginPage.signInClick();
        back();

    }
}