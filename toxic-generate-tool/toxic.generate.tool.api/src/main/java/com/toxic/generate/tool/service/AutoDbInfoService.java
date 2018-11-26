/*
 * Copyright (c) 2018. Toxic
 */

/*
 * Web Site: http://www.reapal.com
 * Since 2014 - 2018
 */

package com.toxic.generate.tool.service;


import java.util.List;
import com.toxic.generate.tool.model.*;
import com.toxic.generate.tool.model.query.*;
import com.toxic.generate.tool.service.base.BaseService;

public interface AutoDbInfoService extends BaseService<AutoDbInfo, Integer>{
	List<AutoDbInfo> queryList(AutoDbInfoQuery autoDbInfoQuery);

//	Page<AutoDbInfo> queryListPage(AutoDbInfoQuery autoDbInfoQuery, Page<AutoDbInfo> page);
}
