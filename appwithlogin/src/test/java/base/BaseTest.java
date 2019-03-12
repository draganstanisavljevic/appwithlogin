package base;

import exceptions.DriverIsNotInitException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import support.PropertiesManager;
import support.Timeouts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static support.Timeouts.IMPLICIT_TIMEOUT;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver;
    private static final Logger LOG = LoggerFactory.getLogger(AbstractLoginTest.class);
    public static PropertiesManager propertiesManager = new PropertiesManager();


    @BeforeMethod(alwaysRun = true)
    public void preConditions() throws DriverIsNotInitException {
        String platformName = propertiesManager.getPlaform();
        LOG.info("------------------------ Platform = " + platformName);
        if(platformName == null){
            platformName = "Android";
        }
        LOG.info("----------------------- INITIALISATION -----------------");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("deviceName", "GGGGNexus  6 MobileAutomation");
        desiredCapabilities.setCapability("platformVersion", "8.0");
        desiredCapabilities.setCapability("app", new File("src/app/testproject-demo-app.apk"));
        desiredCapabilities.setCapability("newCommandTimeout", Timeouts.NEW_COMMAND_TIMEOUT);

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            throw new DriverIsNotInitException("Driver was not init");
        }

        //TODO How it can find implicit timeout without Timeouts.IMPLICIT_TIMEOUT
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void postConditions() {
        LOG.info("----------------------- QUIT -----------------");
        driver.quit();
    }
}
