import sql.query.SqlQueryImpl;

public class Main {
    public static void main(String[] args) {
        SqlQueryImpl sqlQuery = new SqlQueryImpl();

        sqlQuery.noDupValues();
        System.out.println("");
        sqlQuery.uniqueValues();
        System.out.println("");
        sqlQuery.DupValues();
        System.out.println("");
        sqlQuery.DupValuesMinMaxAver();

    }
}
