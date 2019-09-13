package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final String CONFIG_PROPERTIES_PATH = "src/test/resources/config/config.properties";
    private static String property = null;

    /**
     * This method permit the reading of properties files to search an specific one
     * @param variable the name associated to the property that you need to search
     * @return the searched property
     * @throws IOException
     */
    public static String getProperties(String variable) throws IOException {
            InputStream fileInput = new FileInputStream(CONFIG_PROPERTIES_PATH);
            Properties properties = new Properties();
            properties.load(fileInput);
            property = properties.getProperty(variable);
            fileInput.close();
        return property;
    }

}