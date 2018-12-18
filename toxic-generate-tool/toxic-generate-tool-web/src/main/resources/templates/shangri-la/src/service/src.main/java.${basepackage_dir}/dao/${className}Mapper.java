/*
 * Copyright (c) 2018. shangri-la
 */

<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.mapper;

import ${basepackage}.service.dao.BaseMapper;
//import org.apache.ibatis.annotations.Mapper;
import ${basepackage}.service.bean.*;
import org.springframework.stereotype.Repository;


//@Mapper
@Repository
public interface ${className}Mapper extends BaseMapper<${className}>{
}
