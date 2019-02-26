package pageobjects.welcome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobjects.BaseScreen;
import pageobjects.login.LoginScreen;

public class WelcomeScreenIOS extends BaseScreen implements WelcomeScreenInterface{

    public WelcomeScreenIOS(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public LoginScreen logout() {
        return null;
    }

    public boolean isLogoutDisplayed() {
        return false;
    }
}
