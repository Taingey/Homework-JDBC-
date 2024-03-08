package repository;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader {
    public static final Properties properties = new Properties();

    public static void loadProperties() {
        try (BufferedReader reader = new BufferedReader(new FileReader("db.properties"))) {
            properties.load(reader);
        } catch (IOException exception) {
            System.out.println("Problem during loading properties: " + exception.getMessage());
        }
    }
}
