package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHelper {

    private static String property = null;

    public static String getProperties(String variable) {
        try {
            InputStream fileInput = new FileInputStream("src/test/resources/config/config.properties");
            Properties properties = new Properties();
            properties.load(fileInput);
            property = properties.getProperty(variable);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property;
    }

}