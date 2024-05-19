import com.nntk.jdbc.driver.HttpConnection;
import com.nntk.jdbc.driver.HttpDriver;
import com.nntk.jdbc.driver.HttpResultSet;
import com.nntk.jdbc.driver.HttpStatement;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

@Log4j2
public class TestMysqlDriver {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/testdb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true&allowPublicKeyRetrieval=true", "root", "root");


        DatabaseMetaData metaData = conn.getMetaData();
        //Retrieving the columns in the database
        ResultSet rs = metaData.getTables(null, null, "book", null);

        ResultSet colRet = metaData.getColumns(null, "testdb", "book", "%");
        //Printing the column name and size
        while (colRet.next()) {
            String schema = colRet.getString("TABLE_CAT");
            String catalog = colRet.getString("TABLE_SCHEM");
            String catalog2 = colRet.getString(3);
            String catalog3 = colRet.getString(4);
            String catalog4 = colRet.getString(5);

            log.info("{},{},{},{},{}", schema, catalog, catalog2, catalog3, catalog4);
            System.out.println("==");
        }

    }
}
