<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.business;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

import com.reapal.common.model.ResultList;
import com.reapal.common.page.Page;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.model.query.${className}Query;

@Component
public class ${className}Business {

	@Reference(timeout = 3000)
	private ${className}Service ${classNameFirstLower}Service;
	
	/**
	 * 显示列表
	 */
	public ResultList query${className}(${className}Query ${classNameFirstLower}Query,Page page){
		return ${classNameFirstLower}Service.query${className}(${classNameFirstLower}Query,page);
	}
	
	
	/**
	 * 保存信息
	 */
	public void insert${className}(${className} ${classNameFirstLower}){
		if(${classNameFirstLower}.getKeyId()==null || ${classNameFirstLower}.getKeyId().intValue()==0){	
			${classNameFirstLower}Service.insert${className}(${classNameFirstLower});
		}
	}
	
	
	/**
	 * 修改信息
	 */
	public String update${className}(${className} ${classNameFirstLower}){
		if(${classNameFirstLower}.getKeyId()!=null){
			${classNameFirstLower}Service.update${className}(${classNameFirstLower});
	  }
		
		return "";
	}
	
	/**
	 * 得到对象
	 */
	public ${className} get${className}ById(Integer ${classNameFirstLower}Id){
        return ${classNameFirstLower}Service.get${className}ById(${classNameFirstLower}Id);
  }
  
	/**
	 * 删除指定信息
	 */
	public void delete${className}(java.lang.Integer id){
		${classNameFirstLower}Service.delete${className}(id);
	}

}

