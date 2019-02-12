/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.dao.impl;

import com.toxic.generate.tool.dao.CodeDao;
import com.toxic.generate.tool.model.ColumnInfo;
import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午2:07.
 */
@Repository
public class CodeDaoImpl implements CodeDao {
    /**
     * Method:
     * Description: 获取当前数据库所有表信息
     *
     * @param dbconfigInfo
     * @return java.util.List<com.py.code.repository.TableInfo>
     * @Author panying
     * @Data 2018/7/9 下午2:23
     */
    @Override
    public List<TableInfo> getAllTables(DbconfigInfo dbconfigInfo) {

        List<TableInfo> tableList = new ArrayList<TableInfo>();
        //初始化数据库连接
        Connection conn = getConnection(dbconfigInfo);
        try {
            Statement stmt = conn.createStatement();
            String strSql = "";
            if (dbconfigInfo.getUrl().indexOf("mysql") > 0) {
                strSql = "select table_name,TABLE_COMMENT from information_schema.tables where table_schema='" + dbconfigInfo.getSchema() + "'";
            } else {
                strSql = "select table_name,comments from user_tab_comments where table_type='TABLE' order by table_name";
            }
            System.out.println(">>>>>>>>>>>>" + strSql);
            ResultSet rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                TableInfo table = new TableInfo();
                table.setTableName(rs.getString(1));
                table.setComments(rs.getString(2));
                tableList.add(table);
            }

            // 关闭声明
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException("execute sql occer error", e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return tableList;
    }

    /**
     * Method:
     * Description: 获取所有列信息
     *
     * @param tableName
     * @param dbconfigInfo
     * @return com.py.code.repository.TableInfo
     * @Author panying
     * @Data 2018/7/9 下午3:43
     */
    @Override
    public TableInfo getAllColumns(String tableName, DbconfigInfo dbconfigInfo) {
        TableInfo tableInfo = new TableInfo();
        tableInfo.setTableName(tableName);

        Connection conn = getConnection(dbconfigInfo);
        try {
            Statement stmt = conn.createStatement();
            String strSql = "";
            //step1 得到表注解
            if (dbconfigInfo.getUrl().indexOf("mysql") > 0) {
                strSql = "select TABLE_COMMENT from information_schema.tables where table_name='" + tableName + "' and table_schema='" + dbconfigInfo.getSchema() + "'";
            } else {
                strSql = "select comments from user_tab_comments where table_name='" + tableName + "'";
            }
            ResultSet rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                tableInfo.setComments(rs.getString(1));
            }

            //step2 得到字段注解
            if (dbconfigInfo.getUrl().indexOf("mysql") > 0) {
                strSql = "select column_name,column_comment,data_type from Information_schema.columns where table_Name = '" + tableName + "'";
            } else {
                strSql = "select z.COLUMN_NAME,c.comments,z.data_type from user_tab_columns z,user_col_comments c where z.TABLE_NAME=c.table_name and z.COLUMN_NAME=c.column_name and z.Table_Name='" + tableName + "'";
            }
            List<ColumnInfo> colList = new ArrayList<ColumnInfo>();
            rs = stmt.executeQuery(strSql);
            while (rs.next()) {
                ColumnInfo colInfo = new ColumnInfo();
                colInfo.setColName(rs.getString(1));
                colInfo.setComments(rs.getString(2));
                colInfo.setColType(rs.getString(3));
                colList.add(colInfo);
            }
            tableInfo.setListColumn(colList);
            //step3 关闭声明
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException("execute sql occer error", e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return tableInfo;
    }

    /**
     * Method:
     * Description: 保存表与配置信息
     *
     * @param tableInfo
     * @param dbconfigInfo
     * @return void
     * @Author panying
     * @Data 2018/7/9 下午8:33
     */
    @Override
    public void saveComment(TableInfo tableInfo, DbconfigInfo dbconfigInfo) {
        Connection conn = getConnection(dbconfigInfo);
        try {
            Statement stmt = conn.createStatement();
            String strSql = "";

            if (dbconfigInfo.getUrl().indexOf("mysql") > 0) {
                strSql = "ALTER TABLE " + tableInfo.getTableName() + " COMMENT '#" + tableInfo.getComments() + "';";
                stmt.executeUpdate(strSql);
                //stmt.executeUpdate("use information_schema;");
                for (ColumnInfo item : tableInfo.getListColumn()) {
                    strSql = "ALTER TABLE " + tableInfo.getTableName() + " MODIFY COLUMN " + item.getColName() + " " + item.getColType() + " COMMENT '" + item.getComments() + "'; ";
                    System.out.println(">>>>>>>>>>>" + strSql);
                    //strSql = "update information_schema.COLUMNS t set t.column_comment='"+item.getComments()+"' where t.TABLE_SCHEMA='数据库名' and t.table_name='"+tableInfo.getTableName()+"' and t.COLUMN_NAME='"+item.getColName()+"';");
                    stmt.executeUpdate(strSql);
                }
            } else {
                strSql = "COMMENT ON TABLE " + tableInfo.getTableName() + " IS '#" + tableInfo.getComments() + "'";
                stmt.executeUpdate(strSql);
                for (ColumnInfo item : tableInfo.getListColumn()) {
                    strSql = "COMMENT ON COLUMN " + tableInfo.getTableName() + "." + item.getColName() + " IS '" + item.getComments() + "'";
                    stmt.executeUpdate(strSql);
                }
            }
            // 关闭声明
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException("execute sql occer error", e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 获取数据库连接的函数
     *
     * @param
     * @return java.sql.Connection
     * @throws
     * @author py
     * @date 8:49 PM
     */
    private Connection getConnection(DbconfigInfo dbconfigInfo) {

        //创建用于连接数据库的Connection对象
        Connection con = null;
        try {
            // 加载Mysql数据驱动
            Class.forName(dbconfigInfo.getDriver());
            // 创建数据连接
            con = DriverManager.getConnection(dbconfigInfo.getUrl(), dbconfigInfo.getUsername(), dbconfigInfo.getPassword());

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        //返回所建立的数据库连接
        return con;
    }
}
