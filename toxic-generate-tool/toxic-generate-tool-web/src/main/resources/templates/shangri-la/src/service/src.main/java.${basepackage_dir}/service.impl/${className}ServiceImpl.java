<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.service.impl;

import java.util.List;
import ${basepackage}.service.dao.${className}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${basepackage}.service.service.${className}Service;
import ${basepackage}.service.bean.*;
import com.maxim.anepoch.common.base.query.BasicQuery;

/**
 * @author py
 * @date 2019/4
 */
@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className},Long> implements ${className}Service {
	@Autowired
	private ${className}Mapper ${classNameFirstLower}Mapper;

	@Override
	public List<${className}> queryList(${className} ${classNameFirstLower}){
		return ${classNameFirstLower}Mapper.selectList(${classNameFirstLower});
	}

	@Override
	public List<${className}> queryListByPage(BasicQuery basicQuery) {
		return ${classNameFirstLower}Mapper.selectListByPage(basicQuery);
	}

	@Override
	public int queryCountByConditions(${className} ${classNameFirstLower}) {
		return this.${classNameFirstLower}Mapper.getTotleCountByConditions(${classNameFirstLower});
	}

}
