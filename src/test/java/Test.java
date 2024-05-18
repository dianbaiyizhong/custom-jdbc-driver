import com.nntk.jdbc.driver.HttpConnection;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class Test {

    private static final String URL = "jdbc:mysql://localhost:3306/ddd?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        // Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
        Class.forName("com.nntk.jdbc.driver.HttpDriver");

        Connection connection = DriverManager.getConnection("http://api.xxx.com");

        // sql 语句 是使用了 别名的
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from aaa");
        // 获取元数据对象
        ResultSetMetaData metaData = resultSet.getMetaData();

        // 获取一共有多少列
        int columnCount = metaData.getColumnCount();

        log.info("columnCount:{}", columnCount);
        // 将数据封装为Map
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> columnMap = new HashMap<>();
            // 注：列名的索引 起始是 1 不是 0
            for (int i = 1; i <= columnCount; i++) {
                String key = metaData.getColumnName(i);
                Object value = resultSet.getString(i);
                columnMap.put(key, value);
            }
            list.add(columnMap);
        }
        System.out.println(list);
        resultSet.close();
        connection.close();
    }
}


