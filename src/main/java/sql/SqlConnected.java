package sql;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс для соединения с базой данных.
 * getConnectionToDb - возвращает Connection для нужной БД
 */
@NoArgsConstructor
public class SqlConnected {
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/skb";
    static final String USER = "postgres";
    static final String PASS = "0101gznm";

    public Connection getConnectionToDb() {

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

