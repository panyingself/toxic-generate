/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.business;

import com.toxic.generate.tool.config.DbConfig;
import com.toxic.generate.tool.config.DbServer;
import com.toxic.generate.tool.model.AutoDbInfo;
import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;
import com.toxic.generate.tool.model.query.AutoDbInfoQuery;
import com.toxic.generate.tool.service.AutoDbInfoService;
import com.toxic.generate.tool.service.CodeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/6 下午5:39.
 */
@Component
public class DbConfigBusiness {
    @Resource
    private DbConfig dbConfig;
    @Resource
    private CodeService codeService;
    @Resource
    private AutoDbInfoService autoDbInfoService;
    /**
     * Method:
     * Description: 获取数据库配置列表
     * @Author panying
     * @Data 2018/7/9 上午10:06
     * @param
     * @return java.util.List<com.py.code.repository.DbconfigInfo>
     */
//    public List<DbconfigInfo> getDbconfigInfoList(){
    public List<AutoDbInfo> getAutoDbInfoList(){
        List<DbconfigInfo> dbconfigInfoList = new ArrayList<DbconfigInfo>();
        //解析数据库配置
        //走数据库
        List<AutoDbInfo> autoDbInfoList = autoDbInfoService.queryList(new AutoDbInfoQuery());
//        if( null != autoDbInfoList && autoDbInfoList.size() > 0 ){
//            dbconfigInfoList = autoDbInfoList.stream()
//                    .map( x -> this.getDbServerByDb(x)
//                    ).collect(Collectors.toList());
//        }
        //走配置文件
//        if( null != dbConfig){
//            List<DbServer> dbServerList = dbConfig.getDbconfig();
//            dbconfigInfoList = dbServerList.stream()
//                .map( x -> this.getDbServer(x.getCfg())
//                ).collect(Collectors.toList());
//        }
        return autoDbInfoList;
    }
    /**
     *获取dbserver信息
     * @param
     * @return com.py.code.repository.DbconfigInfo
     * @author py
     * @date  5:08 PM
     * @exception
     */
    private DbconfigInfo getDbServer(String str){
        DbconfigInfo dbconfigInfo = new DbconfigInfo();
        String[] splits = str.split("\\|");
        dbconfigInfo.setUrl(splits[0]);
        dbconfigInfo.setDriver(splits[1]);
        dbconfigInfo.setUsername(splits[2]);
        dbconfigInfo.setPassword(splits[3]);
        dbconfigInfo.setSchema(splits[4]);
        dbconfigInfo.setDbName(splits[5]);
        return dbconfigInfo;
    }
    /**
     *
     * @param
     * @return com.toxic.generate.tool.model.DbconfigInfo
     * @author py
     * @date  4:07 PM
     * @exception
     */
    private DbconfigInfo getDbServerByDb(AutoDbInfo autoDbInfo){
        DbconfigInfo dbconfigInfo = new DbconfigInfo();
        dbconfigInfo.setUrl(autoDbInfo.getDbUrl());
        dbconfigInfo.setDriver(autoDbInfo.getDbDriver());
        dbconfigInfo.setUsername(autoDbInfo.getDbUserName());
        dbconfigInfo.setPassword(autoDbInfo.getDbPassWord());
        dbconfigInfo.setSchema(autoDbInfo.getDbSchema());
        dbconfigInfo.setDbName(autoDbInfo.getDbName());
        return dbconfigInfo;
    }
    /**
     * Method:
     * Description: 获取数据库所有表信息
     * @Author panying
     * @Data 2018/7/9 上午11:45
     * @param dbconfigInfo
     * @return java.util.List<com.py.code.repository.TableInfo>
     */
    public List<TableInfo> getAllTables(DbconfigInfo dbconfigInfo){
        List<TableInfo> tableInfoList = new ArrayList<TableInfo>();
        tableInfoList = codeService.getAllTables(dbconfigInfo);
        return tableInfoList;
    }
    /**
     * Method:
     * Description: 获取对应表所有字段信息
     * @Author panying
     * @Data 2018/7/9 下午3:39
     * @param tableName
    * @param dbconfigInfo
     * @return com.py.code.repository.TableInfo
     */
    public  TableInfo getAllColumns(String tableName,DbconfigInfo dbconfigInfo){
        return codeService.getAllColumns(tableName,dbconfigInfo);
    }
    /**
     * Method:
     * Description: 保存表和配置信息
     * @Author panying
     * @Data 2018/7/9 下午8:36
     * @param tableInfo
    * @param dbconfigInfo
     * @return void
     */
    public void saveComment(TableInfo tableInfo,DbconfigInfo dbconfigInfo){
        codeService.saveComment(tableInfo,dbconfigInfo);
    }
}
