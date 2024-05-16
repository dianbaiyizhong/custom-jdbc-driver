import com.nntk.JqConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    private static final String URL = "jdbc:mysql://localhost:3306/ddd?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
       // Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
        Class.forName("com.nntk.JqDriver");

        JqConnection connection = (JqConnection) DriverManager.getConnection("11");

        // sql 语句 是使用了 别名的
        PreparedStatement preparedStatement = connection.prepareStatement("select *  from t_user ");
        ResultSet resultSet = preparedStatement.executeQuery();
        // 获取元数据对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        // 获取一共有多少列
        int columnCount = metaData.getColumnCount();
        // 将数据封装为Map
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> columnMap = new HashMap<>();
            // 注：列名的索引 起始是 1 不是 0
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("getColumnName(i): " + metaData.getColumnName(i));
                System.out.println("getColumnLabel(i): " + metaData.getColumnLabel(i));
                System.out.println("getColumnClassName(i): " + metaData.getColumnClassName(i));
                System.out.println("getColumnType(i): " + metaData.getColumnType(i));
                System.out.println("getColumnTypeName(i): " + metaData.getColumnTypeName(i));
                System.out.println("getScale(i): " + metaData.getScale(i));
                System.out.println("isNullable(i): " + metaData.isNullable(i));
                System.out.println("isAutoIncrement(i): " + metaData.isAutoIncrement(i));
                System.out.println("getTableName(i): " + metaData.getTableName(i));
                System.out.println();

                String key = metaData.getColumnName(i);
                Object value = resultSet.getString(key);
                columnMap.put(key, value);
            }
            list.add(columnMap);
        }
        System.out.println();
        System.out.println(list);
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}


