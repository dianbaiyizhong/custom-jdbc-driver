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


}
