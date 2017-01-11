package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import org.openqa.selenium.By;

import static appium.tutorial.android.util.Helpers.driver;

public class AutomatingLoginTest extends AppiumTest {

    String mailButtonId = "com.cabify.qabify:id/email";
    String passwordButtonId = "com.cabify.qabify:id/password";
    String loginButtonId = "com.cabify.qabify:id/email_sign_in_button";
    String showPasswordId = "com.cabify.qabify:id/text_input_password_toggle";
    String tokenButtonId = "com.cabify.qabify:id/token_button";
    String userLoggedId = "com.cabify.qabify:id/textView";
    String userOnePassword = "password";
    String userOneEmail = "user1@example.com";
    String adminPassword = "nmT8bSVJepgWrryx";
    String adminEmail = "admin@example.com";


    @org.junit.Test
    public void logginUserOne() throws Exception {


        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(userLoggedId).getText().equals("Hi, User1");
    }

    @org.junit.Test
    public void logginUserAdmin() throws Exception {


        driver.findElementById(mailButtonId).sendKeys(adminEmail);
        driver.findElementById(passwordButtonId).sendKeys(adminPassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(userLoggedId).getText().equals("Hi, Admin");
    }

    @org.junit.Test
    public void logginInvalidUser() throws Exception {

        driver.findElementById(mailButtonId).sendKeys("user1example.com");
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        if (driver.findElementById(tokenButtonId).isDisplayed()) {
            throw new Exception("Oops! Impossible login .");
        }

    }

    @org.junit.Test
    public void showPasswordButton() throws Exception {


        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(showPasswordId).click();
        driver.findElement(By.name(userOnePassword));

    }

    @org.junit.Test
    public void shortPassword() throws Exception {


        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys("11=");
        driver.findElementById(loginButtonId).click();
        if (driver.findElementById(tokenButtonId).isDisplayed()) {
            throw new Exception("Oops! Impossible login .");
        }

    }

    @org.junit.Test
    public void tokenUserOne() throws Exception {


        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(tokenButtonId).click();
        driver.findElement(By.name("abcdefghi"));
    }

    @org.junit.Test
    public void tokenUserAdmin() throws Exception {


        driver.findElementById(mailButtonId).sendKeys(adminEmail);
        driver.findElementById(passwordButtonId).sendKeys(adminPassword);
        driver.findElementById(loginButtonId).click();
        driver.findElementById(tokenButtonId).click();
        driver.findElement(By.name("123456789"));
    }
}