/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.model;

import java.io.Serializable;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 上午10:05.
 */
public class ColumnInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;

    private String colName;
    private String colType;
    private String comments;

    public String getColName() {
        return colName;
    }
    public void setColName(String colName) {
        this.colName = colName;
    }
    public String getColType() {
        return colType;
    }
    public void setColType(String colType) {
        this.colType = colType;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}
