package tests;

import base.AbstractLoginTest;
import base.BaseTest;
import io.appium.java_client.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckWelcomePageTest extends BaseTest{

    private static final Logger LOG = LoggerFactory.getLogger(AbstractLoginTest.class);

    @Test(groups = {"Smoke", "Regression"})
    public void checkLoginButton() {
        LOG.info(" -----  checkLoginButton  -------");
        MobileElement button = driver.findElementByClassName("android.widget.Button");
        String text = button.getText();
        String expectedText = "LOGIN";

        Assert.assertEquals(text, expectedText, "Expected: " + text + " Actually: " + expectedText);
    }
}
