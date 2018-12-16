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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin/autodbinfo")
public class AutoDbInfoController{

	@Autowired
	private AutoDbInfoBusiness autoDbInfoBusiness;
	

	/**
	 * 请求新增页面
	 */
	@RequestMapping(value="/add")
	public String toAdd(Model model){
		return "db/db_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultVo addJob(AutoDbInfo autoDbInfo){
		ResultVo resultVo = new ResultVo();
		autoDbInfoBusiness.insertAutoDbInfo(autoDbInfo);
		return new ResultVo();
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(Model model,String id){
		model.addAttribute("db",autoDbInfoBusiness.getAutoDbInfoById(id));
		return "db/db_edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public ResultVo realEdit(AutoDbInfo autoDbInfo){
		ResultVo resultVo = new ResultVo();
		int row = autoDbInfoBusiness.updateAutoDbInfo(autoDbInfo);
		resultVo.setData(row);
		return resultVo;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResultVo realDelete(Model model,String id){
		ResultVo resultVo = new ResultVo();
		autoDbInfoBusiness.deleteAutoDbInfo(id);
		return resultVo;
	}
}

