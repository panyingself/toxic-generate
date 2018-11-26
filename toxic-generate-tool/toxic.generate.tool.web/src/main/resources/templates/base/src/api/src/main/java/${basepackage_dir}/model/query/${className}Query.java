<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.model.query;

import ${basepackage}.model.${className};
import ${basepackage}.model.*;


public class ${className}Query extends ${className} {
	private static final long serialVersionUID = 1L;
	
	/** 关键字查询 */
	private java.lang.String keyWord;

	public java.lang.String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(java.lang.String keyWord) {
		this.keyWord = keyWord;
	}
	
}
