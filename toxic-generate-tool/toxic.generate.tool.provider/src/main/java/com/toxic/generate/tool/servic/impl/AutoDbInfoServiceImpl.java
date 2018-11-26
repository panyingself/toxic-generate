/*
 * Copyright (c) 2018. Toxic
 */

/*
 * Web Site: http://www.reapal.com
 * Since 2014 - 2018
 */

package com.toxic.generate.tool.servic.impl;

import java.util.List;

import com.toxic.generate.tool.servic.impl.base.BaseServiceImpl;
import com.toxic.generate.tool.service.AutoDbInfoService;
import org.springframework.stereotype.Service;
import com.toxic.generate.tool.mapper.*;
import com.toxic.generate.tool.model.*;
import com.toxic.generate.tool.model.query.*;

import javax.annotation.Resource;

@Service
public class AutoDbInfoServiceImpl extends BaseServiceImpl<AutoDbInfo,Integer> implements AutoDbInfoService {
	@Resource
	private AutoDbInfoMapper autoDbInfoMapper;


	public List<AutoDbInfo> queryList(AutoDbInfoQuery autoDbInfoQuery){
		return autoDbInfoMapper.selectList(autoDbInfoQuery);
	}


}
