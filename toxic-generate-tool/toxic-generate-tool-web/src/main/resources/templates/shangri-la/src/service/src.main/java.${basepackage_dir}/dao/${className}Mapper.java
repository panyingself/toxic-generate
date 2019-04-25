<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.mapper;

import ${basepackage}.service.bean.*;
import org.springframework.stereotype.Repository;

/**
 * @author py
 * @date 2019/4
 */
@Repository
public interface ${className}Mapper extends BaseMapper<${className}>{
}
