package org.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public Properties getPropObj() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                    + "\\ConfigurationDetails\\Config.properties");
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
