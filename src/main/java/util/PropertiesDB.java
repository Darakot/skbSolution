package util;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для загрузки пропертей из файла с конфигурацией
 */

@NoArgsConstructor
public class PropertiesDB {
    private static Properties properties;

    static {
        ClassLoader classLoader = PropertiesDB.class.getClassLoader();
        File file = new File(classLoader.getResource("configDB.properties").getFile());
        System.out.println(file.getPath());
        properties = new Properties();

        try {
            FileInputStream fileProperties = new FileInputStream(file);
            properties.load(fileProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getHost(){
        return properties.getProperty("db.host");
    }
    public static String getDriver(){
        return properties.getProperty("db.driver");
    }
    public static String getLogin(){
        return properties.getProperty("db.login");
    }
    public static String getPassword(){
        return properties.getProperty("db.password");
    }
}
