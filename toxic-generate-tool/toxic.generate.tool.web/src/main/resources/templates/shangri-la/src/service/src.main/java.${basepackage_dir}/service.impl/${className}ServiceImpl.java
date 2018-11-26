/*
 * Copyright (c) 2018. Toxic
 */

<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.service.impl;

import java.util.List;
import ${basepackage}.service.dao.${className}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${basepackage}.service.service.AutoDbInfoService;
import ${basepackage}.service.bean.*;
import ${basepackage}.service.bean.query.*;

@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className},String> implements ${className}Service {
	@Autowired
	private ${className}Mapper ${classNameFirstLower}Mapper;


	public List<${className}> queryList(${className}Query ${classNameFirstLower}Query){
		return ${classNameFirstLower}Mapper.selectList(${classNameFirstLower}Query);
	}


}
