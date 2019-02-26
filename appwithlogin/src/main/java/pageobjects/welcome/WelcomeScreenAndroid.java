package pageobjects.welcome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BaseScreen;
import pageobjects.login.LoginScreen;

public class WelcomeScreenAndroid extends BaseScreen implements  WelcomeScreenInterface {

    private By logout = By.id("io.testproject.demo:id/logout");

    public WelcomeScreenAndroid(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public LoginScreen logout() {
        driver.findElement(logout).click();
        return new LoginScreen(driver);
    }

    public boolean isLogoutDisplayed() {

        /*Wait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.))*/

        //TODO instead of for implement wait until keybooard is present
        for (int i = 0; i < 10000; i++) {
            System.out.println("----------------------------------");
        }
        driver.hideKeyboard();
        return driver.findElement(logout).getText().equals("LOGOUT");
    }
}
