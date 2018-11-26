/*
 * Copyright (c) 2018. Toxic
 */

/*
 * Web Site: http://www.reapal.com
 * Since 2014 - 2018
 */

package com.toxic.generate.tool.model.query;

import com.toxic.generate.tool.model.AutoDbInfo;
import com.toxic.generate.tool.model.*;


public class AutoDbInfoQuery extends AutoDbInfo {
	private static final long serialVersionUID = 1L;
	
	/** 关键字查询 */
	private String keyWord;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
