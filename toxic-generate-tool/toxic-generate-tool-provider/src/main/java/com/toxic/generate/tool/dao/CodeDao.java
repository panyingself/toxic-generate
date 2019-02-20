/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.dao;


import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;

import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午2:06.
 */
public interface CodeDao {
    /**
     * 获取所有表信息
     *
     * @param dbconfigInfo
     * @return
     */
    List<TableInfo> getAllTables(DbconfigInfo dbconfigInfo);

    /**
     * 获取所有列信息
     *
     * @param tableName
     * @param dbconfigInfo
     * @return
     */
    TableInfo getAllColumns(String tableName, DbconfigInfo dbconfigInfo);

    /**
     * 修改表与配置信息
     *
     * @param tableInfo
     * @param dbconfigInfo
     */
    void saveComment(TableInfo tableInfo, DbconfigInfo dbconfigInfo);
}
