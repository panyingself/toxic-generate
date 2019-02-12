<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.bize;

import ${basepackage}.service.bean.${className};
import ${basepackage}.service.service.${className}Service;
import com.maxim.anepoch.common.base.ListResult;
import com.maxim.anepoch.common.base.query.BasicQuery;
import com.maxim.anepoch.common.diff.api.LocationPm;
import com.maxim.anepoch.common.monitor.BizTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ${className}BizImpl implements ${className}Biz {

private static final Logger LOGGER = LoggerFactory.getLogger(${className}BizImpl.class);
	@Resource
	private ${className}Service ${classNameFirstLower}Service;
	public static final String CHANGE_LOG_RESOURCE_KEY = "${classNameFirstLower}";
	public static final String BIZ_TYPE = "${classNameFirstLower}";

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

				private void changeLog(LocationPm pm) {
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

				private void changeLog(LocationPm pm) {

					}
				}.execute();
	}

	@Override
	public ListResult<${className}> findAll(Integer currentPage, Integer pageSize) {
			return new BizTemplate<ListResult<${className}>>() {
				@Override
				protected ListResult<${className}> process() {
						BasicQuery basicQuery = new BasicQuery();
						basicQuery.setPaging(currentPage,pageSize);
						List<${className}> list = ${classNameFirstLower}Service.findAllByPage(basicQuery);
						int count = ${classNameFirstLower}Service.queryCountByConditions(${classNameFirstLower});
						ListResult<${className}> result = new ListResult<>(currentPage,pageSize,list).setTotal(count);
						return result;
				}
			}.execute();
	}

}

