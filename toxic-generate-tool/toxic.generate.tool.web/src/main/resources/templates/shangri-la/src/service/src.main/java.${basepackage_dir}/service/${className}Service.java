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
import ${basepackage}.service.bean.query.*;

public interface ${className}Service extends BaseService<${className}, String>{

		List<${className}> findAll(${className}Query ${classNameFirstLower}Query);

		List<${className}> findAllByPage(BasicQuery basicQuery);
}
