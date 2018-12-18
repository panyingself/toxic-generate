<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.repository.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.toxic.auth.page.Page;
import com.toxic.auth.service.impl.base.BaseServiceImpl;
import ${basepackage}.model.*;
import ${basepackage}.mapper.*;
import ${basepackage}.model.*;
import ${basepackage}.model.query.*;

@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className},Integer> implements ${className}Service {
	@Resource
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
