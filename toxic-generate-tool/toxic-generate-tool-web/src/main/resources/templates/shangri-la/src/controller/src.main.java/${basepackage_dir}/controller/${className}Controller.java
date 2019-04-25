<#include "/custom.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage_controller};

import ${basepackage}.service.bean.${className};
import ${basepackage}.biz.${className}Biz;
import com.maxim.anepoch.common.base.ListResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

@Controller
@RequestMapping("api/baseinfo/${classNameLowerCase}")
public class ${className}Controller{

	@Resource
	private ${className}Biz ${classNameFirstLower}Biz;
	
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



		@PostMapping("save")
		public boolean save(@RequestBody ${className} ${classNameFirstLower}) {
				return ${classNameFirstLower}Biz.save(${classNameFirstLower});
		}

		@PostMapping("edit")
		public boolean edit(@RequestBody ${className} ${classNameFirstLower}) {
				return ${classNameFirstLower}Biz.edit(${classNameFirstLower});
		}

		@GetMapping("findAll")
		public ListResult<${className}> findAll(@RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
		@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
				return ${classNameFirstLower}Biz.findAll(currentPage, pageSize);
		}
}

