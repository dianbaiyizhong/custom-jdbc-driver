package com.nntk.jdbc.driver.adapter;

import cn.hutool.core.lang.Singleton;
import com.nntk.jdbc.driver.DsBasicInfo;

import java.util.List;
import java.util.Map;

public abstract class HttpAdapter {


    protected DsBasicInfo getDsBasicInfo() {
        DsBasicInfo dsBasicInfo = Singleton.get(DsBasicInfo.class);
        return dsBasicInfo;
    }


    public abstract List<Map<String, String>> sendHttp(String sql);


    public abstract List<Map<String, String>> getTables();

    public abstract List<Map<String, String>> getColumns(String tb);

    public abstract List<Map<String, String>> getSchemas();

}
