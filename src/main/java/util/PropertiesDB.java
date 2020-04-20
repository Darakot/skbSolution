package util;

import lombok.extern.log4j.Log4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для загрузки пропертей из файла с конфигурацией
 */

@Log4j
public class PropertiesDB {
    private static Properties properties;

    static {
        ClassLoader classLoader = PropertiesDB.class.getClassLoader();
        File file = new File(classLoader.getResource("configDB.properties").getFile());
        properties = new Properties();

        try(FileInputStream fileProperties = new FileInputStream(file)) {
            properties.load(fileProperties);
        } catch (IOException e) {
            log.error(e.getMessage());
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
