package support;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import pageobjects.login.LoginScreen;

public class LoginUIStrategy implements LoginStrategy {

    private AppiumDriver<MobileElement> driver;

    public LoginUIStrategy(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.setUserName(username).setPassword(password).login();
    }
}
