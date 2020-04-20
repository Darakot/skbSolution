package sql.query;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import sql.SqlConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для запросов SQL
 * noDupValues - выводит значения без дублей
 * uniqueValues - выводит уникальные значения
 * DupValues - выводит дубли
 * DupValuesMinMaxAver - выводит 3 значения дублей(минимальный,максимальный и средний)
 * query - универсальный метод для запроса SQL
 */
@NoArgsConstructor
@Log4j
public class SqlQueryImpl implements SqlQuery {
    private SqlConnect sqlConnected = new SqlConnect();
    private List<String> values;

    private final String NO_DUP_VALUES = "SELECT * FROM table1 GROUP BY col1 ORDER BY col1 ASC";
    private final String UNIQUE_VALUES = "SELECT DISTINCT col1  FROM table1 ORDER BY col1 ASC";
    private final String DUP_VULUES = "SELECT col1 FROM table1 GROUP BY col1 HAVING count(*)> 1";
    private final String DUP_VULUES_MIN_MAX_AVER = "SELECT MIN(col1) as min," +
            "MAX(col1) as max," +
            "AVG(col1) as avg " +
            "FROM (SELECT col1 FROM table1 GROUP BY col1 HAVING count(*)> 1) f";

    @Override
    public void noDupValues() {
        values = Arrays.asList("col1");
        query(NO_DUP_VALUES,values);
    }

    @Override
    public void uniqueValues() {
        values = Arrays.asList("col1");
        query(UNIQUE_VALUES,values);
    }

    @Override
    public void DupValues() {
        values = Arrays.asList("col1");
        query(DUP_VULUES,values);
    }

    @Override
    public void DupValuesMinMaxAver() {
        values = Arrays.asList("min","max","avg");
        query(DUP_VULUES_MIN_MAX_AVER,values);
    }

    private void query(String strQuery, List<String> values) {
        try(Connection connection = sqlConnected.getConnectionToDb();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(strQuery)) {

            while (rs.next()) {
                for (String s:values) {
                    String value = rs.getString(s);
                    System.out.println("value: " + value);
                }
            }

        } catch (SQLException e) {
            log.error("некорректный запрос к БД " + strQuery);
        }
    }
}
