<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.reapal.common.page.Page;
import ${basepackage}.repository.*;
import ${basepackage}.mapper.*;
import ${basepackage}.model.*;
import ${basepackage}.model.query.*;

@Service
public class ${className}ServiceImpl implements ${className}Service {
	@Autowired
	private ${className}Mapper ${classNameFirstLower}Mapper;


	public List<${className}> queryList(${className}Query ${classNameFirstLower}Query){
		return ${classNameFirstLower}Mapper.selectList(${classNameFirstLower}Query);
	}

	public Page<${className}> queryListPage(${className}Query ${classNameFirstLower}Query, Page<${className}> page){
        PageHelper.startPage(page.getCurrent(), page.getSize());
        page.setRecords(${classNameFirstLower}Mapper.selectList(${classNameFirstLower}Query));
		return page;
	}
}
