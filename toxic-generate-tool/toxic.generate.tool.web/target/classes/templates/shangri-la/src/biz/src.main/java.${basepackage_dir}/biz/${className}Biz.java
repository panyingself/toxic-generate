<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.biz;

import ${basepackage}.bean.${className};
import com.maxim.anepoch.common.base.ListResult;

public interface ${className}biz {
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
		ListResult<Hub> findAll(Integer currentPage, Integer pageSize);

}

