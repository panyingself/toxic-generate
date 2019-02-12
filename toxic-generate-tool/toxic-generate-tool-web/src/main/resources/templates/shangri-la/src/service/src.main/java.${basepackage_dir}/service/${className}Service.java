/*
 * Copyright (c) 2018. Toxic
 */

<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.repository;


import java.util.List;
import ${basepackage}.service.bean.*;
import com.maxim.anepoch.common.base.query.BasicQuery;

public interface ${className}Service extends BaseService<${className}, Long>{

		List<${className}> queryList(${className} ${classNameFirstLower});

		List<${className}> queryListByPage(BasicQuery query);

		int queryCountByConditions(${className} ${classNameFirstLower});
}
