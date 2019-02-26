package pageobjects.welcome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class WelcomeScreenFactory {

    public static WelcomeScreenInterface getWelcomeScreen(AppiumDriver<MobileElement> driver) {
        if (driver.getPlatformName().equals("iOS")) {
            return new WelcomeScreenIOS(driver);
        } else {
            return new WelcomeScreenAndroid(driver);
        }
    }
}
