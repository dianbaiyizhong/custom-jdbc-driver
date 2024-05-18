package com.nntk.jdbc.driver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Properties;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DsBasicInfo {

    private String url;
    private Properties info;
}
