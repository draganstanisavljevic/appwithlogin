package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

public class BaseScreen {

    protected AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void hideKeyboard(){
        driver.hideKeyboard();
    }

    public void navigateBack(){
        driver.navigate().back();
    }
}
