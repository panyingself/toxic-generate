<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.repository;


import java.util.List;
import com.github.pagehelper.PageHelper;
import ${basepackage}.model.*;
import ${basepackage}.model.query.*;
import com.toxic.auth.service.base.BaseService;

public interface ${className}Service extends BaseService<${className}, String>{

	List<${className}> queryList(${className}Query ${classNameFirstLower}Query);

	Page<${className}> queryListPage(${className}Query ${classNameFirstLower}Query, Page<${className}> page);
}
