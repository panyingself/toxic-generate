<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.repository;


import java.util.List;
import ${basepackage}.service.bean.*;
import com.maxim.anepoch.common.base.query.BasicQuery;
/**
 * @author py
 * @date 2019/4
 */
public interface ${className}Service extends BaseService<${className}, Long>{
        /**
         * 根据对象条件-查询集合信息
         *
         * @param ${classNameFirstLower}
         * @return
         */
		List<${className}> queryList(${className} ${classNameFirstLower});

        /**
         * 根据对象条件-分页查询集合信息
         *
         * @param query
         * @return
         */
		List<${className}> queryListByPage(BasicQuery query);

        /**
         * 根据对象条件-查询总记录数
         *
         * @param ${classNameFirstLower}
         * @return
         */
		int queryCountByConditions(${className} ${classNameFirstLower});
}
