/*
 * Copyright (c) 2018. shangri-la
 */

package ${basepackage}.service.dao;
import com.maxim.anepoch.common.base.query.BasicQuery;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T var1);

    int delete(Object var1);

    int update(T var1);

    T selectOne(T var1);

    List<T> selectList(T var1);

    List<T> selectListByPage(BasicQuery query);

    int getTotleCountByConditions(T var1);
}