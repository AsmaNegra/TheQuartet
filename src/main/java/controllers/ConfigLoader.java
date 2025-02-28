package controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    public static String getApiKey() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(fis);
            return properties.getProperty("GEMINI_API_KEY");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
