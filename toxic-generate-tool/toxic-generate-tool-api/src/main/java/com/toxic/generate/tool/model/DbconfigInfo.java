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

    /** 数据库 */
    private String url="";
    private String driver="";	//com.mysql.jdbc.Driver
    private String username="";
    private String password="";
    private String schema;
    private String catalog;
    private String dbType;
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
