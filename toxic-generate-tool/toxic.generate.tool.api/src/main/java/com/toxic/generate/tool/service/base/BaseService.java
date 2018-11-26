/*
 * Copyright (c) 2018. Toxic
 */

package com.toxic.generate.tool.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author py
 * @date 2018/11/26 3:35 PM.
 */
public interface BaseService<T, PK extends Serializable> {
    int insert(T var1);

    int delete(PK var1);

    int update(T var1);

    T getById(PK var1);

    T selectOne(T var1);

    List<T> selectList(T var1);
}
