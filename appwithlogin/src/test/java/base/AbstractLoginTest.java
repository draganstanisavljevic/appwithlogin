package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import pageobjects.login.LoginScreen;
import support.LoginUIStrategy;

public class AbstractLoginTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractLoginTest.class);

    //All previous methods and setters are not necessary because I use strategy patern
    @BeforeMethod(alwaysRun = true)
    public void login(){
        LOG.info("Pre-conditions for log in tests");
        new LoginScreen(driver).login("Dragan", "12345", new LoginUIStrategy(driver));
    }
}
