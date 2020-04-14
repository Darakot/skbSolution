package sql.query;

import lombok.NoArgsConstructor;
import sql.SqlConnected;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public class SqlQuery implements SqlQueryImpl {
    private SqlConnected sqlConnected = new SqlConnected();
    private List<String> values;

    private final String NO_DUP_VALUES = "SELECT * FROM table1 GROUP BY col1";
    private final String UNIQUE_VALUES = "SELECT DISTINCT col1  FROM table1 ";
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
        try {
            ResultSet rs = sqlConnected.getConnectionToDb().createStatement().executeQuery(strQuery);
            while (rs.next()) {
                for (String s:values) {
                    String value = rs.getString(s);
                    System.out.println("value: " + value);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
