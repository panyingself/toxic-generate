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
    /**
     * 保存对象方法
     *
     * @param var1
     * @return
     */
    boolean save(T var1);

    /**
     * 根据对象条件-删除方法
     *
     * @param var1
     * @return
     */
    int delete(T var1);

    /**
     * 根据对象条件-编辑方法
     *
     * @param var1
     * @return
     */
    boolean edit(T var1);

    /**
     * 根据对象条件-查询单个对象方法
     *
     * @param var1
     * @return
     */
    T findOne(T var1);

}
