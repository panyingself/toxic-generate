/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.model;

import java.io.Serializable;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 上午10:02.
 */
public class TableInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表注释
     */
    private String comments;
    /**
     * 表字段集合
     */
    private List<ColumnInfo> listColumn;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<ColumnInfo> getListColumn() {
        return listColumn;
    }

    public void setListColumn(List<ColumnInfo> listColumn) {
        this.listColumn = listColumn;
    }
}
