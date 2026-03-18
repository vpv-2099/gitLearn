package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigData {

    public String retrunPropertyValue(String propertyName) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        String s = prop.getProperty(propertyName);
        return s;
    }
    public ConfigData() throws FileNotFoundException {
    }
}
