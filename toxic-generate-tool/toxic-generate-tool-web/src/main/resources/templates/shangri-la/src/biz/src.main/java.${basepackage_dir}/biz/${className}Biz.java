<#include "/custom.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.biz;

import ${basepackage}.service.bean.${className};
import java.util.List;


/**
 * @author py
 * @date 2019/4
 */
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
		 * 查询${className}集合
		 * @param ${classNameFirstLower}
		 * @return
		 */
		List<${className}> queryList(${className} ${classNameFirstLower});
}

