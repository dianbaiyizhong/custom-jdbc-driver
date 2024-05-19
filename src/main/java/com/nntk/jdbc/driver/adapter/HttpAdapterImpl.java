package com.nntk.jdbc.driver.adapter;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.google.common.collect.Lists;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Log4j2
public class HttpAdapterImpl extends HttpAdapter {
    @Override
    public List<Map<String, String>> sendHttp(String sql) {
        List<SQLStatement> list = SQLUtils.parseStatements(sql, "mysql");
        if (!(list.get(0) instanceof SQLSelectStatement)) {
            Map<String, String> errorRow = new HashMap<>();
            errorRow.put("error_info", "不支持非select语句");

            return Lists.newArrayList(errorRow);
        }

        String url = getDsBasicInfo().getUrl();
        HttpResponse response = HttpRequest.get(url).execute();

        String rawJson = response.body();

        List<Map<String, String>> result = JsonPath.read(rawJson, "$.result");
        return result;
    }

    @Override
    public List<Map<String, String>> getTables() {
        Map<String, String> tableInfo = new HashMap<>();
        tableInfo.put("Table_NAME", "t1");
        return Lists.newArrayList(tableInfo);
    }

    @Override
    public List<Map<String, String>> getColumns(String tb) {
        Map<String, String> tableInfo = new HashMap<>();
        String schema = Optional.ofNullable(getDsBasicInfo().getInfo().getProperty("schema")).orElse("请设置你的schema属性，方便显示");

        // 缺一个，datagrip都显示不出来，尤其是TABLE_NAME要对应上
        tableInfo.put("COLUMN_NAME", "id");
        tableInfo.put("ORDINAL_POSITION", "1");
        tableInfo.put("TABLE_CAT", "def");
        tableInfo.put("TABLE_SCHEM", schema);
        tableInfo.put("TABLE_NAME", "t1");
        tableInfo.put("DATA_TYPE", "12");
        tableInfo.put("TYPE_NAME", "VARCHAR");
        tableInfo.put("COLUMN_SIZE", "255");
        return Lists.newArrayList(tableInfo);
    }

    @Override
    public List<Map<String, String>> getSchemas() {
        Map<String, String> tableInfo = new HashMap<>();

        String schema = Optional.ofNullable(getDsBasicInfo().getInfo().getProperty("schema")).orElse("请设置你的schema属性，方便显示");
        tableInfo.put("TABLE_SCHEM", schema);
        tableInfo.put("TABLE_CATALOG", "def");
        return Lists.newArrayList(tableInfo);
    }


}
