<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.biz;

import ${basepackage}.service.bean.${className};
import com.maxim.anepoch.common.base.ListResult;

public interface ${className}Biz {
		/**
		 * 新增${className}
		 *
		 * @param ${classNameFirstLower}
		 * @return
		 */
		boolean save(${className} ${classNameFirstLower});

		/**
		 * 修改${className}
		 *
		 * @param ${classNameFirstLower}
		 * @return
		 */
		boolean edit(${className} ${classNameFirstLower});

		/**
		 * 查询${className}
		 * @param currentPage
		 * @param pageSize
		 * @return
		 */
		ListResult<${className}> findAll(Integer currentPage, Integer pageSize);

}

