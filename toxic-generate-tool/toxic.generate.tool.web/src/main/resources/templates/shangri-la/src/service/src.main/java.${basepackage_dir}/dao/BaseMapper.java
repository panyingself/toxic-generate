/*
 * Copyright (c) 2018. Toxic
 */

package ${basepackage}.service.dao;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T var1);

    int delete(Object var1);

    int update(T var1);

    T getById(Object var1);

    T selectOne(T var1);

    List<T> selectList(T var1);

    List<T> selectAllByPage(T var1);

    int findAllCount();
}