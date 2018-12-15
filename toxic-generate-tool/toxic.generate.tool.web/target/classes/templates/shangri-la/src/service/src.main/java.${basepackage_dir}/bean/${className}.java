<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.bean;

import java.io.Serializable;


public class ${className} implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    
	<@generateFields/>
	<@generateProperties/>

}

<#macro generateFields>

	<#list table.columns as column>

	/** ${column.columnAlias} */
	private ${column.javaType} ${column.columnNameLower};
	<#if (column.remarks)?index_of("#LFK") &gt; 0 >
	private ${column.javaType} foreignKey;
	</#if>
	</#list>

</#macro>

<#macro generateProperties>
	<#list table.columns as column>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	<#if (column.remarks)?index_of("#LFK") &gt; 0 >
	public ${column.javaType} getForeignKey() {
		return this.foreignKey;
	}
	
	public void setForeignKey(${column.javaType} value) {
		this.foreignKey = value;
	}
	</#if>
	
	<#if (column.remarks)?index_of("#LCP") &gt; 0 >
	public String get${column.columnName}Name() {
		ParameterCache cache = (ParameterCache) SpringUtils.getBean("parameterCache");
		String strName = "";
		if(StringUtils.isNotEmpty(${column.columnNameLower})) {
			strName = cache.queryNameById(${column.columnNameLower});
		}		
		return strName;
	}
	</#if>
	
	<#if (column.remarks)?index_of("#LCD") &gt; 0 >
	public String get${column.columnName}Name() {
		DeptCache cache = (DeptCache) SpringUtils.getBean("deptCache");
		String strName = "";
		if(StringUtils.isNotEmpty(${column.columnNameLower})) {
			strName = cache.queryNameById(${column.columnNameLower});
		}		
		return strName;
	}
	</#if>
	
	<#if (column.remarks)?index_of("#LCA") &gt; 0 >
	public String get${column.columnName}Name() {
		AreaInfoCache cache = (AreaInfoCache) SpringUtils.getBean("areaInfoCache");
		String strName = "";
		if(StringUtils.isNotEmpty(${column.columnNameLower})) {
			strName = cache.queryNameById(${column.columnNameLower});
		}		
		return strName;
	}
	</#if>
	
	</#list>
</#macro>



