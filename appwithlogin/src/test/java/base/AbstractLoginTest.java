package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import pageobjects.login.LoginScreen;
import support.LoginUIStrategy;

public class AbstractLoginTest extends BaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractLoginTest.class);
    private static final Object[][] DATA_ADMINISTRATOR = { new Object[] { "Dragan", "12345" }};
    private static final Object[][] DATA_INVALID_USERNAME = { new Object[] { "Dragan", "12345" }};
    private static final Object[][] DATA_INVALID_PASSWORD = { new Object[] { "username", "123455" }};

    @DataProvider
    public Object[][] data1() {
        return DATA_ADMINISTRATOR;
    }

    @DataProvider
    public Object[][] data2() {
        return DATA_INVALID_USERNAME;
    }

    @DataProvider
    public Object[][] data3() {
        return DATA_INVALID_PASSWORD;
    }


    //All previous methods and setters are not necessary because I use strategy patern
    @BeforeMethod(alwaysRun = true)
    public void login(Object[] data){
        LOG.info("Pre-conditions for log in tests");
        String username = (String) data[0];
        String password = (String) data[1];
        new LoginScreen(driver).login(username, password, new LoginUIStrategy(driver));
    }
}
