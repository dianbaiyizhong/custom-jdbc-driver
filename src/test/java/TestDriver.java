import com.nntk.jdbc.driver.HttpConnection;
import com.nntk.jdbc.driver.HttpDriver;
import com.nntk.jdbc.driver.HttpResultSet;
import com.nntk.jdbc.driver.HttpStatement;

import java.sql.DriverManager;

public class TestDriver {
    public static void main(String[] args) throws Exception {
        Class.forName(HttpDriver.class.getName());
        HttpConnection conn = (HttpConnection) DriverManager.getConnection("http://localhost:3000/json/modelList.json");
        HttpStatement statement = (HttpStatement) conn.createStatement();
        HttpResultSet resultSet = (HttpResultSet) statement.executeQuery("insert  into xxx");
        while (resultSet.next()) {
            String l1 = resultSet.getString(1);
            System.out.println(l1);
        }
        resultSet.close();

    }
}
