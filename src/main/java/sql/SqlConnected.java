package sql;

import lombok.NoArgsConstructor;
import util.PropertiesDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для соединения с базой данных.
 * getConnectionToDb - возвращает Connection для нужной БД
 */
@NoArgsConstructor
public class SqlConnected {

    public Connection getConnectionToDb() {

        Connection connection = null;
        try {
            Class.forName(PropertiesDB.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager
                    .getConnection(PropertiesDB.getHost(), PropertiesDB.getLogin(), PropertiesDB.getPassword());
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

