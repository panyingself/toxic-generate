/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.controller.db;

import com.toxic.generate.tool.business.DbConfigBusiness;
import com.toxic.generate.tool.controller.base.BaseController;
import com.toxic.generate.tool.model.ColumnInfo;
import com.toxic.generate.tool.model.DbconfigInfo;
import com.toxic.generate.tool.model.TableInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/6 下午3:30.
 */
@Controller
@RequestMapping("/initcode")
public class InitCodeController extends BaseController {
    @Resource
    private DbConfigBusiness dbConfigBusiness;

    /**
     * Method:
     * Description: 初始化数据库配置信息
     *
     * @param model
     * @return java.lang.String
     * @Author panying
     * @Data 2018/7/6 下午3:30
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("dbConfigList", dbConfigBusiness.getAutoDbInfoList());
        return "db/db_list";
    }

    /**
     * Method:
     * Description: 获取所有对应数据库所有表信息
     *
     * @param model
     * @param dbConfig
     * @return java.lang.String
     * @Author panying
     * @Data 2018/7/9 上午10:10
     */

    @RequestMapping(method = RequestMethod.GET)
    public String tablelist(Model model, DbconfigInfo dbConfig) {
        List<TableInfo> tableList = dbConfigBusiness.getAllTables(dbConfig);
        model.addAttribute("dbConfig", dbConfig);
        model.addAttribute("tableList", tableList);
        return "db/table_list";
    }

    /**
     *操作指定表
     * @param
     * @return java.lang.String
     * @author py
     * @date  8:14 PM
     * @exception
     */
    @RequestMapping(value = "/{tableName}", method = RequestMethod.GET)
    public String itemList(Model model, DbconfigInfo dbconfigInfo, @PathVariable String tableName) {
        TableInfo tableInfo = dbConfigBusiness.getAllColumns(tableName, dbconfigInfo);
        model.addAttribute("tableInfo", tableInfo);
        model.addAttribute("dbConfig", dbconfigInfo);
        return "db/column_list";
    }

    /**
     * 保存配置信息
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String save(Model model, DbconfigInfo dbconfigInfo, TableInfo tableInfo) {
        String[] arrRemark = request.getParameterValues("remarks");
        List<ColumnInfo> listItem = new ArrayList<ColumnInfo>();
        for (String remark : arrRemark) {
            System.out.println(remark);
            String[] mark = remark.split("@");
            ColumnInfo item = new ColumnInfo();
            item.setColName(mark[0]);
            item.setColType(mark[1]);
            item.setComments(mark[2]);
            listItem.add(item);
        }
        tableInfo.setListColumn(listItem);
        dbConfigBusiness.saveComment(tableInfo, dbconfigInfo);
        return "200";
    }

}
