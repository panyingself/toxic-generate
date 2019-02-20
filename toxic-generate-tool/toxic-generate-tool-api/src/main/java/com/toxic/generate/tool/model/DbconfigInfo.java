/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.model;

import java.io.Serializable;

/**
 * Title:
 * Description:数据库配置类
 *
 * @author py
 * @date 2018/7/6 下午3:31.
 */
public class DbconfigInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    /**
     * 地址信息
     */
    private String url;
    /**
     * 驱动信息
     */
    private String driver;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;
    /**
     * 数据库schema
     */
    private String schema;
    /**
     * 数据库cataLog
     */
    private String catalog;
    /**
     * 数据库类型
     */
    private String dbType;
    /**
     * 数据库dbname
     */
    private String dbName;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}
