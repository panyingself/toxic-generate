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
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@Autowired
	private ${className}Business ${classNameFirstLower}Business;
	
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

	/**
	 * 显示列表
	 */
	@RequestMapping
	public String list(Model model,${className}Query ${classNameFirstLower}Query,Page page){
		<#if isFK == 1 >
		<#if (javaType?index_of("Integer")) &gt; 0 >
		if(${classNameFirstLower}Query.getForeignKey() != null){
			${classNameFirstLower}Query.set${columnName}(${classNameFirstLower}Query.getForeignKey());
		}
		<#else>
		if(StringUtils.isNotEmpty(${classNameFirstLower}Query.getForeignKey())){
			${classNameFirstLower}Query.set${columnName}(${classNameFirstLower}Query.getForeignKey());
		}
		</#if>
		</#if>
		
		ResultList resultList = ${classNameFirstLower}Business.query${className}(${classNameFirstLower}Query,page);
		List<${className}> ${classNameFirstLower}List = resultList.getList();
		page = resultList.getPage();
		
		
		model.addAttribute("${classNameFirstLower}List", ${classNameFirstLower}List);
		model.addAttribute("page", page);
		model.addAttribute("${classNameFirstLower}Query", ${classNameFirstLower}Query);
		
		return "admin/${path_model}/${classNameLowerCase}_list";
	}
	
	/**
	 * 请求新增页面
	 */
	@RequestMapping(value="/new")
	public String toAdd(Model model<#if isFK == 1 >,${className} ${classNameFirstLower}</#if>){
		<#if isFK == 1 >
		<#if (javaType?index_of("Integer")) &gt; 0 >
		if(${classNameFirstLower}.getForeignKey() != null){
			${classNameFirstLower}.set${columnName}(${classNameFirstLower}.getForeignKey());
		}
		<#else>
		if(StringUtils.isNotEmpty(${classNameFirstLower}.getForeignKey())){
			${classNameFirstLower}.set${columnName}(${classNameFirstLower}.getForeignKey());
		}
		</#if>
		model.addAttribute("${classNameFirstLower}", ${classNameFirstLower});
		</#if>
		model.addAttribute("_method", "post");
		return "admin/${path_model}/${classNameLowerCase}_edit";
	}
	
	/**
	 * 保存信息
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String save${className}(Model model,${className} ${classNameFirstLower}){
		if(${classNameFirstLower}.getKeyId()==null || ${classNameFirstLower}.getKeyId().intValue()==0){
			String userName = UserRoleFilter.getUserName(request);
			${classNameFirstLower}.setCreateUserId(userName);
			${classNameFirstLower}.setModifyUserId(userName);
			
			${classNameFirstLower}Business.insert${className}(${classNameFirstLower});
		}
		<#if isFK == 1 >
		<#if (javaType?index_of("Integer")) &gt; 0 >
		if(${classNameFirstLower}.getForeignKey() != null){
			return "redirect:/admin/${classNameLowerCase}?foreignKey="+${classNameFirstLower}.getForeignKey();
		}
		<#else>
		if(StringUtils.isNotEmpty(${classNameFirstLower}.getForeignKey())){
			return "redirect:/admin/${classNameLowerCase}?foreignKey="+${classNameFirstLower}.getForeignKey();
		}
		</#if>
		</#if>
		return "redirect:/admin/${classNameLowerCase}";
	}
	
	/**
	 * 请求编辑页面
	 */
	@RequestMapping(value="/{id}", method =RequestMethod.GET)
	public String toEdit(Model model,@PathVariable Integer id<#if isFK == 1 >,${javaType} foreignKey</#if>){
		${className} ${classNameFirstLower} = ${classNameFirstLower}Business.get${className}ById(id);
		<#if isFK == 1 >
		${classNameFirstLower}.setForeignKey(foreignKey);		
		</#if>
		model.addAttribute("${classNameFirstLower}", ${classNameFirstLower});
		model.addAttribute("_method", "put");
		return "admin/${path_model}/${classNameLowerCase}_edit";
	}
	
	/**
	 * 修改信息
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update${className}(Model model,${className} ${classNameFirstLower}){
		if(${classNameFirstLower}.getKeyId()!=null){
			String userName = UserRoleFilter.getUserName(request);
			${classNameFirstLower}.setModifyUserId(userName);
			${classNameFirstLower}Business.update${className}(${classNameFirstLower});
	    }
		
		<#if isFK == 1 >
		<#if (javaType?index_of("Integer")) &gt; 0 >
		if(${classNameFirstLower}.getForeignKey() != null){
			return "redirect:/admin/${classNameLowerCase}?foreignKey="+${classNameFirstLower}.getForeignKey();
		}
		<#else>
		if(StringUtils.isNotEmpty(${classNameFirstLower}.getForeignKey())){
			return "redirect:/admin/${classNameLowerCase}?foreignKey="+${classNameFirstLower}.getForeignKey();
		}
		</#if>		
		</#if>
		return "redirect:/admin/${classNameLowerCase}";
	}
	
	
	/**
	 * 删除指定信息
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void delete${className}(Model model,@PathVariable java.lang.Integer id){
		${classNameFirstLower}Business.delete${className}(id);
	}
	/** 
	 * 批量删除
	 */
	@RequestMapping(method=RequestMethod.DELETE)
	public void batchDelete${className}(java.lang.Integer[] ids) {
		for(int i = 0; i < ids.length; i++) {
			${classNameFirstLower}Business.delete${className}(ids[i]);
		}
	}
}

