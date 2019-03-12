package support;

import java.util.Properties;

public class PropertiesManager {
    //-Duser=...

    String plaform;
    String user;
    String device;

    public PropertiesManager() {
        Properties properties =System.getProperties();
        plaform = properties.getProperty("platform");
        user = properties.getProperty("user");
        device = properties.getProperty("device");
    }

    public String getPlaform() {
        return plaform;
    }

    public String getUser() {
        return user;
    }

    public String getDevice() {
        return device;
    }
}
