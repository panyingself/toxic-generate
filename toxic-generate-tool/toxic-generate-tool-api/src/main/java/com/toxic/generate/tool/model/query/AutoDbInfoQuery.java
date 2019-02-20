/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.model.query;

import com.toxic.generate.tool.model.AutoDbInfo;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/7/9 上午10:05.
 */
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
