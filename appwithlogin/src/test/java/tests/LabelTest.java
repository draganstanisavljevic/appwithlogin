package tests;

import base.AbstractLoginTest;
import io.appium.java_client.MobileElement;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.login.LoginScreen;
import pageobjects.welcome.WelcomeScreenFactory;
import pageobjects.welcome.WelcomeScreenInterface;

public class LabelTest extends AbstractLoginTest{

    @Test(groups = {"Smoke", "Regression"}, dataProvider = "data1")
    public void checkGreetingLabel(String data, String data2) {

        //This is without AbstractLoginTest
        //new LoginScreen(driver).login("Dragan", "12345", new LoginUIStrategy(driver));

        MobileElement label = driver.findElementById("io.testproject.demo:id/greetings");
        String greeting = label.getText();
        String expectedGreeting = "Hello Dragan";

        Assert.assertEquals(greeting, expectedGreeting, "Expected greeting: " + expectedGreeting + " Actually: " + greeting);

    }


    @Test(groups = {"Smoke", "Regression"}, dataProvider = "data2")
    public void checkLoginWithInvalidUsername(String data, String data2) {

        //This is without AbstractLoginTest
        //new LoginScreen(driver).login("Dragan", "12345", new LoginUIStrategy(driver));

        MobileElement label = driver.findElementById("io.testproject.demo:id/greetings");
        String greeting = label.getText();
        String expectedGreeting = "Hello Dragan";

        Assert.assertEquals(greeting, expectedGreeting, "Expected greeting: " + expectedGreeting + " Actually: " + greeting);

    }

    @Test(dataProvider = "data3")
    public void checkLoginWithInvalidPassword(String username, String password) {

        MobileElement label = driver.findElementById("io.testproject.demo:id/greetings");
        String greeting = label.getText();
        String expectedGreeting = "Hello Dragan";

        Assert.assertEquals(greeting, expectedGreeting, "Expected greeting: " + expectedGreeting + " Actually: " + greeting);

    }

    @Test(groups = {"Smoke"}, dataProvider = "data1")
    public void checkLogoutButton(String username, String password) {

        WelcomeScreenInterface welcomeScreenInterface = WelcomeScreenFactory.getWelcomeScreen(driver);
        boolean isLogoutDisplayed = welcomeScreenInterface.isLogoutDisplayed();

        Assert.assertEquals(true, isLogoutDisplayed, "Logout button is not displayed");

        LoginScreen loginScreen = welcomeScreenInterface.logout();

        Assertions.assertThat(loginScreen.isLoginButtonContainsCorrectText())
                .as("Login should be displayed!")
                .withFailMessage("Login text is not correct")
                .isTrue();
    }

}
