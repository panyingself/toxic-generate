/*
 * Copyright (c) 2018. shangri-la
 */

package ${basepackage}.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author py
 * @date 2018/11/26 3:35 PM.
 */
public interface BaseService<T, PK extends Serializable> {
    boolean save(T var1);

    boolean edit(T var1);

    int findAllCount();

    T findById(PK var1);

    T findOne(T var1);

}
