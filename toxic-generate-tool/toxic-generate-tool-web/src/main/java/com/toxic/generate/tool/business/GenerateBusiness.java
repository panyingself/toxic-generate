/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.business;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import com.toxic.generate.tool.model.CodeConfig;
import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 下午3:58.
 */
@Component
public class GenerateBusiness {
    /**
     * Method:
     * Description:初始化数据库信息
     * 1、设置数据库属性：数据库连接串、用户名、密码
     * 2、设置配置属性：
     * @Author panying
     * @Data 2018/7/9 下午4:09
     * @param dbconfigInfo
    * @param tableInfo
    * @param codeConfig
     * @return void
     */
    public void generator(DbconfigInfo dbconfigInfo, TableInfo tableInfo, CodeConfig codeConfig){

        init(dbconfigInfo,tableInfo,codeConfig);

        GeneratorFacade g = new GeneratorFacade();
//        try {
//            g.deleteOutRootDir();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            g.generateByTable(tableInfo.getTableName(),codeConfig.getTemplateName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void init(DbconfigInfo dbconfigInfo,TableInfo tableInfo,CodeConfig codeConfig){
        //数据库类型至java类型映射
        GeneratorProperties.setProperty("java_typemapping.java.sql.Timestamp", "java.util.Date");
        GeneratorProperties.setProperty("java_typemapping.java.sql.Date", "java.util.Date");
        GeneratorProperties.setProperty("java_typemapping.java.sql.Time", "java.util.Date");
        GeneratorProperties.setProperty("java_typemapping.java.lang.Byte", "Integer");
        GeneratorProperties.setProperty("java_typemapping.java.lang.Short", "Integer");
        GeneratorProperties.setProperty("java_typemapping.java.math.BigDecimal", "Long");
        GeneratorProperties.setProperty("java_typemapping.java.sql.Clob", "String");

        if(dbconfigInfo.getUrl().indexOf("mysql")>0){
            GeneratorProperties.setProperty("jdbc.url", dbconfigInfo.getUrl()+"?useUnicode=true&amp;characterEncoding=UTF-8");
            GeneratorProperties.setProperty("dbType", "mysql");
        }else{
            GeneratorProperties.setProperty("jdbc.url", dbconfigInfo.getUrl());
            GeneratorProperties.setProperty("dbType", "oracle");
        }
        GeneratorProperties.setProperty("jdbc.driver", dbconfigInfo.getDriver());
        GeneratorProperties.setProperty("jdbc.username", dbconfigInfo.getUsername());
        GeneratorProperties.setProperty("jdbc.password", dbconfigInfo.getPassword());
        if(null != (dbconfigInfo.getSchema()) && !"".equals(dbconfigInfo.getSchema())) {
            GeneratorProperties.setProperty("jdbc.schema", dbconfigInfo.getSchema());
        }
        //GeneratorProperties.setProperty("jdbc.catalog", codeConfig.getCatalog());


        if(null != (codeConfig.getOutRoot()) && !"".equals(codeConfig.getOutRoot())) {
            GeneratorProperties.setProperty("outRoot", codeConfig.getOutRoot());
        }
        GeneratorProperties.setProperty("tableRemovePrefixes", codeConfig.getTableRemovePrefixes());

        GeneratorProperties.setProperty("namespace", codeConfig.getNamespace());

        String model = "";
        if(tableInfo.getComments().indexOf("#")>0) {
            model = tableInfo.getComments().substring(tableInfo.getComments().indexOf("#")+1);
        }

        GeneratorProperties.setProperty("basepackage", codeConfig.getBasepackage() + model);
        GeneratorProperties.setProperty("basepackage_controller", codeConfig.getBasepackage() + ".controller");
        GeneratorProperties.setProperty("path_model", codeConfig.getPath_model()+model);
        GeneratorProperties.setProperty("path_mybatis", codeConfig.getPath_mybatis()+model);
        GeneratorProperties.setProperty("path_admin", codeConfig.getPath_admin()+model);
        GeneratorProperties.setProperty("path_front", codeConfig.getPath_front()+model);
        GeneratorProperties.setProperty("path_html5", codeConfig.getPath_html5()+model);

    }
}
