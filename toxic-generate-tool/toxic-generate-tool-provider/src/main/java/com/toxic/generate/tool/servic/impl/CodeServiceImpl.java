/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.servic.impl;

import com.toxic.generate.tool.dao.CodeDao;
import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;
import com.toxic.generate.tool.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 上午11:48.
 */
@Service
public class CodeServiceImpl implements CodeService {
    @Resource
    private CodeDao codeDao;

    @Override
    public List<TableInfo> getAllTables(DbconfigInfo dbconfigInfo) {
        return codeDao.getAllTables(dbconfigInfo);
    }

    @Override
    public TableInfo getAllColumns(String tableName, DbconfigInfo dbconfigInfo) {
        return codeDao.getAllColumns(tableName, dbconfigInfo);
    }

    @Override
    public void saveComment(TableInfo tableInfo, DbconfigInfo dbconfigInfo) {
        codeDao.saveComment(tableInfo, dbconfigInfo);
    }
}
