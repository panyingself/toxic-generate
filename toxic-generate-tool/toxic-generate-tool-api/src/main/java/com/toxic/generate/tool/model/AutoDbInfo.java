/*
 * Copyright (c) 2018. Toxic
 */

/*
 * Web Site: http://www.reapal.com
 * Since 2014 - 2018
 */

package com.toxic.generate.tool.model;

import java.io.Serializable;
import java.util.Date;


public class AutoDbInfo implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 主键 */
	private String keyId;
	/** db_url路径 */
	private String dbUrl;
	/** db_driver驱动信息 */
	private String dbDriver;
	/** db用户名 */
	private String dbUserName;
	/** db密码 */
	private String dbPassWord;
	/** db_schema信息 */
	private String dbSchema;
	/** db数据库名称 */
	private String dbName;
	/** db delete_flag */
	private int deleteFlag;
	/** db delete_flag */
	private Date modifyDateTime;

	public Date getModifyDateTime() {
		return modifyDateTime;
	}

	public void setModifyDateTime(Date modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getKeyId() {
		return this.keyId;
	}
	
	public void setKeyId(String value) {
		this.keyId = value;
	}
	
	
	
	
	
	public String getDbUrl() {
		return this.dbUrl;
	}
	
	public void setDbUrl(String value) {
		this.dbUrl = value;
	}
	
	
	
	
	
	public String getDbDriver() {
		return this.dbDriver;
	}
	
	public void setDbDriver(String value) {
		this.dbDriver = value;
	}
	
	
	
	
	
	public String getDbUserName() {
		return this.dbUserName;
	}
	
	public void setDbUserName(String value) {
		this.dbUserName = value;
	}
	
	
	
	
	
	public String getDbPassWord() {
		return this.dbPassWord;
	}
	
	public void setDbPassWord(String value) {
		this.dbPassWord = value;
	}
	
	
	
	
	
	public String getDbSchema() {
		return this.dbSchema;
	}
	
	public void setDbSchema(String value) {
		this.dbSchema = value;
	}
	
	
	
	
	
	public String getDbName() {
		return this.dbName;
	}
	
	public void setDbName(String value) {
		this.dbName = value;
	}
	
	
	
	
	

}

