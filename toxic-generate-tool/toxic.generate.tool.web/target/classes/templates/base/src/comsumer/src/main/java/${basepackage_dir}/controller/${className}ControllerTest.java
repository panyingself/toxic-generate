<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage_controller};

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.reapal.common.controller.BaseController;
import com.reapal.common.model.ResultList;
import com.reapal.common.page.Page;
import com.reapal.common.util.StringUtils;
import com.reapal.payframework.core.auth.utils.UserRoleFilter;

import ${basepackage}.model.*;
import ${basepackage}.business.*;
import ${basepackage}.model.query.*;

@Controller
@RequestMapping("/admin/${classNameLowerCase}")
public class ${className}Controller extends BaseController{

	<#assign isFK = 0 />
	<#assign columnName = "" />
	<#assign javaType = "" />
	<#list table.columns as column>
	<#if (column.remarks)?index_of("#LFK") &gt; 0 >
		<#assign isFK = 1 />
		<#assign javaType = column.javaType />
		<#assign columnName = column.columnName />
	</#if>
	</#list>


@Autowired
private ${className}Business ${classNameFirstLower}Business;

/**
 * 显示列表
 */
@RequestMapping(value = "/list",method={RequestMethod.POST,RequestMethod.GET})
@ResponseBody
public ResultVo list(@RequestBody ${className}RequestVo ${classNameFirstLower}RequestVo){
		ResultVo resultVo = ${classNameFirstLower}Business.query${className}(${classNameFirstLower}RequestVo.get${className}Query(),${classNameFirstLower}RequestVo.getPage());
		if (null != resultVo.getData()) {
		resultVo.setCode(SqlEnum.SUCCESS.getCode());
		resultVo.setMsg(SqlEnum.SUCCESS.getMsg());
		} else {
		resultVo.setCode(SqlEnum.NONE.getCode());
		resultVo.setMsg(SqlEnum.NONE.getMsg());
		}
		return resultVo;
		}

/**
 * Method:  添加新闻
 * Description:
 * Author: pan ying
 * Date: 2018/6/13 17:43
 *
 * @param newsRequestVo
 * @return com.reapal.openapi.web.vo.ResultVo
 */
@RequestMapping(value = "/save" ,method={RequestMethod.POST,RequestMethod.GET})
@ResponseBody
public ResultVo save${className}(@RequestBody ${className}RequestVo ${classNameFirstLower}RequestVo){
		ResultVo resultVo = new ResultVo();
		${classNameFirstLower}Business.insert(${classNameFirstLower}RequestVo);
		return  resultVo;
		}


@RequestMapping(value = "/readcount" ,method={RequestMethod.POST,RequestMethod.GET})
@ResponseBody
public void readCount(@RequestBody ${className}RequestVo ${classNameFirstLower}RequestVo) {

		}

/**
 * 修改信息
 */
@RequestMapping(value="/update",method={RequestMethod.POST,RequestMethod.GET})
@ResponseBody
public ResultVo update${className}(@RequestBody  ${className} ${classNameFirstLower}){
		ResultVo resultVo = new ResultVo();
		if(${classNameFirstLower}.getId()!=null){
		${classNameFirstLower}Business.update${className}(${classNameFirstLower});
		}
		return resultVo;
		}



/**
 * 删除指定信息
 */
@RequestMapping(value="/delete",method={RequestMethod.POST,RequestMethod.DELETE})
@ResponseBody
public ResultVo delete${className}(@RequestBody ${className} ${classNameFirstLower}){
		ResultVo resultVo = new ResultVo();
		${classNameFirstLower}Business.delete${className}(${classNameFirstLower}.getId());
		return  resultVo;
		}
/**
 * 批量删除$
 */
@RequestMapping(value =  "/deletebatch" ,method={RequestMethod.POST,RequestMethod.GET})
@ResponseBody
public ResultVo batchDelete${className}(@RequestBody ResultVo resultVo) {
		String[] str = resultVo.getIds();
		for(int i = 0; i < str.length; i++) {
		${classNameFirstLower}Business.delete${className}(str[i]);
		}
		return  resultVo;
		}

		}

