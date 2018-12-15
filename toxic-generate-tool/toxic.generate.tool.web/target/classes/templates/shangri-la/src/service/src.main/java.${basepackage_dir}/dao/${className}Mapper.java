/*
 * Copyright (c) 2018. Toxic
 */

<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.mapper;

import ${basepackage}.service.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${basepackage}.service.bean.*;

@Mapper
public interface ${className}Mapper extends BaseMapper<${className}>{
}
