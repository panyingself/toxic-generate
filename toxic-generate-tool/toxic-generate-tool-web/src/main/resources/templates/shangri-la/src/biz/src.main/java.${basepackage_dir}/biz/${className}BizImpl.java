<#include "/custom.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.bize;

import ${basepackage}.service.bean.${className};
import ${basepackage}.biz.${className}Biz;
import ${basepackage}.service.service.${className}Service;
import com.maxim.anepoch.common.monitor.BizTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author py
 * @date 2019/4
 */
@Service
public class ${className}BizImpl implements ${className}Biz {

private static final Logger LOGGER = LoggerFactory.getLogger(${className}BizImpl.class);
	@Resource
	private ${className}Service ${classNameFirstLower}Service;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean save(${className} ${classNameFirstLower}) {
			return new BizTemplate<Boolean>() {
				@Override
				protected void checkParam() {
				}

				@Override
				protected Boolean process() {
						${classNameFirstLower}Service.save(${classNameFirstLower});
						return true;
				}
			}.execute();
		}

		@Override
		@Transactional(rollbackFor = Exception.class)
		public boolean edit(${className} ${classNameFirstLower}) {
				return new BizTemplate<Boolean>() {
					@Override
					protected void checkParam() {
					}

					@Override
					protected Boolean process() {
							${className} old${className} = ${classNameFirstLower}Service.findOne(${classNameFirstLower});
							${classNameFirstLower}Service.edit(${classNameFirstLower});
							return true;
					}
				}.execute();
		}

		@Override
		@Transactional(rollbackFor = Exception.class)
		public List<${className}> queryList(${className} ${classNameFirstLower}) {
				return new BizTemplate<List<${className}>>() {
			@Override
			protected void checkParam() {
					}

			@Override
			protected List<${className}> process() {
					List<${className}> ${classNameFirstLower}List = new ArrayList<>();
					${classNameFirstLower}List = ${classNameFirstLower}Service.queryList(${classNameFirstLower});
					return ${classNameFirstLower}List;
					}
				}.execute();
		}

}

