import com.nntk.jdbc.driver.HttpConnection;
import com.nntk.jdbc.driver.HttpResultSet;
import com.nntk.jdbc.driver.HttpStatement;

import java.sql.DriverManager;

public class TestDriver {
    public static void main(String[] args) throws Exception {

        Class.forName("com.nntk.jdbc.driver.HttpDriver");
        HttpConnection conn = (HttpConnection) DriverManager.getConnection("11");
        HttpStatement statement = (HttpStatement) conn.createStatement();
        HttpResultSet resultSet = (HttpResultSet) statement.executeQuery("select");
        System.out.println(resultSet.getMetaData());
        while (resultSet.next()) {
            String l1 = resultSet.getString(1);
            String l2 = resultSet.getString(2);
            System.out.println(l1 + "=============" + l2);
        }

        resultSet.close();

    }
}
