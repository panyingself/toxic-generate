/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
    /**
     * 插入单条记录
     *
     * @param var1
     * @return
     */
    int insert(T var1);

    /**
     * 物理删除单条记录
     *
     * @param var1
     * @return
     */
    int delete(Object var1);

    /**
     * 修改记录
     *
     * @param var1
     * @return
     */
    int update(T var1);

    /**
     * 根据主键获取记录
     *
     * @param var1
     * @return
     */
    T selectByPk(Object var1);

    /**
     * 查询单条记录
     *
     * @param var1
     * @return
     */
    T selectOne(T var1);

    /**
     * 条件查询全量recordList记录
     *
     * @param var1
     * @return
     */
    List<T> selectList(T var1);
}