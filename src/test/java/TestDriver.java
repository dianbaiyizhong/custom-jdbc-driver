import com.nntk.JqConnection;
import com.nntk.JqResultSet;
import com.nntk.JqStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDriver {
    public static void main(String[] args) throws Exception {

        Class.forName("com.nntk.JqDriver");
        JqConnection conn = (JqConnection) DriverManager.getConnection("11");
        JqStatement statement = (JqStatement) conn.createStatement();
        JqResultSet resultSet = (JqResultSet) statement.executeQuery("select");
        System.out.println(resultSet.getMetaData());
        while (resultSet.next()) {
            String l1 = resultSet.getString("l1");
            String l2 = resultSet.getString("l2");
            System.out.println(l1 + "=============" + l2);
        }

        resultSet.close();

    }
}
