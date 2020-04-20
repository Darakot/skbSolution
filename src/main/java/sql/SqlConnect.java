package sql;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import util.PropertiesDB;

import java.sql.*;

/**
 * Класс для соединения с базой данных.
 * getConnectionToDb - возвращает Connection для нужной БД
 */
@NoArgsConstructor
@Log4j
public class SqlConnect {

    public Connection getConnectionToDb() {

        try{
            Connection connection = DriverManager.getConnection(
                    PropertiesDB.getHost(),
                    PropertiesDB.getLogin(),
                    PropertiesDB.getPassword());
            Class.forName(PropertiesDB.getDriver());
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            log.error("Строка подключения к БД некорректна " + e.getMessage());
        }

        return null;
    }
}

