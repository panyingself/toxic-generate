<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   

package ${basepackage}.bize;

import com.maxim.anepoch.auth.UserDetailContextHolder;
import ${basepackage}.service.bean.${className};
import ${basepackage}.service.constant.ErrorCodeConstant;
import ${basepackage}.service.service.${className}Service;
import com.maxim.anepoch.baseinfo.utils.PatternTemplate;
import ${basepackage}.utils.PatternTemplate;
import com.maxim.anepoch.common.base.ListResult;
import com.maxim.anepoch.common.base.query.BasicQuery;
import com.maxim.anepoch.common.diff.api.DiffAPI;
import com.maxim.anepoch.common.diff.api.LocationPm;
import com.maxim.anepoch.common.monitor.BizTemplate;
import com.maxim.anepoch.common.utils.ConditionUtils;
import com.maxim.anepoch.common.utils.LengthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
public class ${className}Impl implements ${className}Biz {

private static final Logger LOGGER = LoggerFactory.getLogger(HubBizImpl.class);
	@Resource
	private ${className}Service ${classNameFirstLower}Service;
	public static final String CHANGE_LOG_RESOURCE_KEY = "${classNameFirstLower}";
	public static final String BIZ_TYPE = "baseinfo";

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean save(${className} ${classNameFirstLower}) {
			return new BizTemplate<Boolean>() {
				@Override
				protected void checkParam() {
				}

				@Override
				protected Boolean process() {
						hubService.save(${classNameFirstLower});
						DiffAPI.opResLog(${classNameFirstLower}, this::changeLog);
						return true;
				}

				private void changeLog(LocationPm pm) {
						pm.bizType(BIZ_TYPE)
						.resourceKey(CHANGE_LOG_RESOURCE_KEY)
						.uniquenessId(${classNameFirstLower}.getId().toString())
						.operator(UserDetailContextHolder.getUserDetail().getUserId().toString());
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
							${className} old${className} = ${classNameFirstLower}Service.findById(${classNameFirstLower}.getId());
							${classNameFirstLower}Service.edit(${classNameFirstLower});
							DiffAPI.opResLog(old${classNameFirstLower}, ${classNameFirstLower}, this::changeLog);
							return true;
					}

				private void changeLog(LocationPm pm) {
						pm.bizType(BIZ_TYPE)
						.resourceKey(CHANGE_LOG_RESOURCE_KEY)
						.uniquenessId(${classNameFirstLower}.getId().toString())
						.operator(UserDetailContextHolder.getUserDetail().getUserId().toString());
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
						List<${className}> list = ${classNameFirstLower}Service.findAll(basicQuery);
						int count = ${classNameFirstLower}Service.findAllCount();
						ListResult<${className}> result = new ListResult<>(currentPage,pageSize,list).setTotal(count);
						return result;
				}
			}.execute();
	}

}

