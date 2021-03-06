
package ${basepackage}.service.impl;

import ${basepackage}.service.dao.BaseMapper;
import ${basepackage}.service.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author py
 * @date 2018/11/26 3:52 PM.
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
    @Autowired
    private BaseMapper<T> baseMapper;

    public BaseServiceImpl() {
    }
    @Override
    public boolean save(T record) {
        return this.baseMapper.insert(record) > 0;
    }
    @Override
    public int delete(T record) {
        return baseMapper.delete(record);
    }
    @Override
    public boolean edit(T record) {
        return this.baseMapper.update(record) > 0;
    }
    @Override
    public T findOne(T var1) {
        return this.baseMapper.selectOne(var1);
    }



}