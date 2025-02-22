package supports;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
    public static Properties readPropertiesFile(String filePath) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
        }
        return properties;
    }

    public static void main(String[] args) {
        String filePath = "D:\\AK47 Automation\\AK47\\src\\test\\resources\\enviroment.properties"; // Update this path as needed
        Properties properties = readPropertiesFile(filePath);

        // Example: Retrieve a property value
        String value = properties.getProperty("base_url", "DefaultValue");
        System.out.println("Property Value: " + value);
    }

    public static String getBaseUrl(){
        String filePath = "D:\\AK47 Automation\\AK47\\src\\test\\resources\\enviroment.properties"; // Update this path as needed
        Properties properties = readPropertiesFile(filePath);

        // Example: Retrieve a property value
        return properties.getProperty("base_url", "DefaultValue");
    }
}
