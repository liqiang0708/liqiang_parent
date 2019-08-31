package com.liqiang.base.mapper;

import com.liqiang.base.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 基础Mapper
 */
public interface BaseMapper<T> {

    /**
     * 保存一个对象
     * @param t
     */
    void save(T t);

    /**
     * 移除一个对象
     * @param id
     */
    void remove(Serializable id);

    /**
     * 更新一个对象
     * @param t
     */
    void update(T t);

    /**
     * 通过id加载一个对象
     * @param id
     * @return
     */
    T loadById(Serializable id);

    /**
     * 加载所有对象
     * @return
     */
    List<T> loadAll();

    Long queryTotal(BaseQuery query);

    List<T> queryRows(BaseQuery query);
}
