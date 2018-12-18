/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.service;


import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;

import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 上午11:47.
 */
public interface CodeService {
    List<TableInfo> getAllTables(DbconfigInfo dbconfigInfo);
    //获取所有列信息
    TableInfo getAllColumns(String tableName, DbconfigInfo dbconfigInfo);
    //保存表与配置信息
    void saveComment(TableInfo tableInfo, DbconfigInfo dbconfigInfo);
}
