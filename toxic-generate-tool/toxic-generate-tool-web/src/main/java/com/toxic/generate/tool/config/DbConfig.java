/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/6 下午4:20.
 */
@Component
@ConfigurationProperties(prefix = "dbconfiglist")
@PropertySource("classpath:config/dbConfig.yml")
public class DbConfig {
    List<DbServer> dbconfig = new ArrayList<DbServer>();

    public List<DbServer> getDbconfig() {
        return dbconfig;
    }

    public void setDbconfig(List<DbServer> dbconfig) {
        this.dbconfig = dbconfig;
    }
}
