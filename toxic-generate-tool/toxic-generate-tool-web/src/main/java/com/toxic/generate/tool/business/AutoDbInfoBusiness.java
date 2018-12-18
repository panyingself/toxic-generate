/*
 * Web Site: http://www.toxic.com py
 * Since 2014 - 2018
 */


package com.toxic.generate.tool.business;

import com.toxic.generate.tool.model.AutoDbInfo;
import com.toxic.generate.tool.service.AutoDbInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AutoDbInfoBusiness {

	@Resource
	private AutoDbInfoService autoDbInfoService;
	

	/**
	 * 保存信息
	 */
	public void insertAutoDbInfo(AutoDbInfo autoDbInfo){
		autoDbInfoService.insert(autoDbInfo);
	}
	
	
	/**
	 * 修改信息
	 */
	public int updateAutoDbInfo(AutoDbInfo autoDbInfo){
		int row = autoDbInfoService.update(autoDbInfo);
		return row;
	}
	
	/**
	 * 得到对象
	 */
	public AutoDbInfo getAutoDbInfoById(String autoDbInfoId){
        return autoDbInfoService.getById(autoDbInfoId);
  }
  
	/**
	 * 删除指定信息
	 */
	public void deleteAutoDbInfo(String id){
		AutoDbInfo autoDbInfo = new AutoDbInfo();
		autoDbInfo.setKeyId(id);
		autoDbInfo.setDeleteFlag(0);
		autoDbInfoService.update(autoDbInfo);
	}

}

