<#include "/custom.include">
        <#assign className = table.className>
        <#assign classNameFirstLower = className?uncap_first>
        <#assign classNameLowerCase = className?lower_case>
        <#assign pkJavaType = table.idColumn.javaType>

package ${basepackage}.bize;

import ${basepackage}.service.bean.${className};
import ${basepackage}.common.convert.AbstractBeanConvert;


/**
 * @author py
 * @date 2019/4
 */
public class ${className}Convert extends AbstractBeanConvert<${className},${className}Bo>{
    @Override
    public ${className}Bo convertToResponse(${className} ${classNameFirstLower}) {
        if (Objects.isNull(${classNameFirstLower})) {
            return null;
        }
        ${className}Bo ${classNameFirstLower}Bo = new ${className}Bo();
        <@generatePropertiesResponse/>
        return ${classNameFirstLower}Bo;
    }

    @Override
    public ${className} convertToRequest(${className}Bo ${classNameFirstLower}Bo) {
        if (Objects.isNull(${classNameFirstLower}Bo)) {
        return null;
        }
        ${className} ${classNameFirstLower} = new ${className}();
        <@generatePropertiesRequest/>
        return ${classNameFirstLower};
    }
}

<#macro generatePropertiesRequest>
<#list table.columns as column>
        ${classNameFirstLower}.set${column.columnName}(${classNameFirstLower}Bo.get${column.columnName}());
</#list>
</#macro>

<#macro generatePropertiesResponse>
<#list table.columns as column>
        ${classNameFirstLower}Bo.set${column.columnName}(${classNameFirstLower}.get${column.columnName}());
</#list>
</#macro>