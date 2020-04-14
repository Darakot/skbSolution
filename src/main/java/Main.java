import sql.query.SqlQuery;

public class Main {
    public static void main(String[] args) {
        SqlQuery sqlQuery = new SqlQuery();

        sqlQuery.noDupValues();
        System.out.println("");
        sqlQuery.uniqueValues();
        System.out.println("");
        sqlQuery.DupValues();
        System.out.println("");
        sqlQuery.DupValuesMinMaxAver();
    }
}
