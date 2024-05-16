package com.nntk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


public class Columns {

    private Map<Integer, String> columnIndexNameMap = new HashMap<>();

    public void addColumn(Integer index, String name) {
        columnIndexNameMap.put(index, name);
    }

    public String getName(Integer index) {
        return columnIndexNameMap.get(index);
    }

    public Integer size() {
        return columnIndexNameMap.size();
    }
}
