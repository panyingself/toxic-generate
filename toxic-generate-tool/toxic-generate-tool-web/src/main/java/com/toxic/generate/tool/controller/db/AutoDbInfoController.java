/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */


package com.toxic.generate.tool.controller.db;

import com.toxic.generate.tool.business.AutoDbInfoBusiness;
import com.toxic.generate.tool.model.AutoDbInfo;
import com.toxic.generate.tool.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/autodbinfo")
public class AutoDbInfoController {
    @Autowired
    private AutoDbInfoBusiness autoDbInfoBusiness;

    /**
     * 跳转至添加页面
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author py
     * @date 9:23 PM
     */
    @RequestMapping(value = "/add")
    public String toAdd(Model model) {
        return "db/db_add";
    }

    /**
     * 添加操作
     *
     * @param
     * @return com.toxic.generate.tool.vo.ResultVo
     * @throws
     * @author py
     * @date 9:24 PM
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addJob(AutoDbInfo autoDbInfo) {
        autoDbInfoBusiness.insertAutoDbInfo(autoDbInfo);
        return new ResultVo();
    }

    /**
     * 跳转至db_edit页面
     *
     * @param
     * @return java.lang.String
     * @throws
     * @author py
     * @date 9:18 PM
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model, String id) {
        model.addAttribute("db", autoDbInfoBusiness.getAutoDbInfoById(id));
        return "db/db_edit";
    }

    /**
     * 编辑
     *
     * @param
     * @return com.toxic.generate.tool.vo.ResultVo
     * @throws
     * @author py
     * @date 9:22 PM
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo realEdit(AutoDbInfo autoDbInfo) {
        ResultVo resultVo = new ResultVo();
        int row = autoDbInfoBusiness.updateAutoDbInfo(autoDbInfo);
        resultVo.setData(row);
        return resultVo;
    }

    /**
     * 删除
     *
     * @param
     * @return com.toxic.generate.tool.vo.ResultVo
     * @throws
     * @author py
     * @date 9:23 PM
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo realDelete(Model model, String id) {
        ResultVo resultVo = new ResultVo();
        autoDbInfoBusiness.deleteAutoDbInfo(id);
        return resultVo;
    }
}

