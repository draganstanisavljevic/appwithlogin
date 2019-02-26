package pageobjects.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.BaseScreen;
import pageobjects.welcome.WelcomeScreenAndroid;
import support.LoginStrategy;

public class LoginScreen extends BaseScreen {

    private static final Logger LOG = LoggerFactory.getLogger(LoginScreen.class);

    @FindBy(id="io.testproject.demo:id/name")
    private MobileElement userName;

    @FindBy(id = "io.testproject.demo:id/password")
    private MobileElement password;

    @FindBy(id = "io.testproject.demo:id/login")
    private MobileElement loginButton;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public LoginScreen setUserName(String username){
        this.userName.sendKeys(username);
        return this;
    }

    public LoginScreen setPassword(String password){
        this.password.sendKeys(password);
        return this;
    }

    public void login(){
        loginButton.click();
    }

    public WelcomeScreenAndroid login(String username, String password, LoginStrategy loginStrategy) {
        LOG.info("Logging in...");
        loginStrategy.login(username, password);
        return new WelcomeScreenAndroid(driver);
    }

    public boolean isLoginButtonContainsCorrectText(){
        return loginButton.getText().equals("LOGIN");
    }
}
