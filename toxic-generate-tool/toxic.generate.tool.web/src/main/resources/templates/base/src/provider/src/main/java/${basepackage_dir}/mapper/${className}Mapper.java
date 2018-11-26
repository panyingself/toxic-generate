<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.mapper;

import com.reapal.common.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import ${basepackage}.model.*;

@Mapper
public interface ${className}Mapper extends BaseMapper<${className}>{

}
