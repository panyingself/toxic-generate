<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.repository;


import java.util.List;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.reapal.common.page.Page;
import ${basepackage}.model.*;
import ${basepackage}.model.query.*;

@Service
public interface ${className}Service extends BaseService<${className}, String>{

	List<${className}> queryList(${className}Query ${classNameFirstLower}Query);

	Page<${className}> queryListPage(${className}Query ${classNameFirstLower}Query, Page<${className}> page);
}
