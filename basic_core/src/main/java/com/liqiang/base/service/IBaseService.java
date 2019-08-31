package com.liqiang.base.service;

import com.liqiang.base.query.BaseQuery;
import com.liqiang.util.PageList;

import java.io.Serializable;
import java.util.List;

public interface IBaseService<T> {
    /**
     * 添加一个对象
     * @param t
     */
    void add(T t);

    /**
     * 删除一个对象
     * @param id
     */
    void del(Serializable id);

    /**
     * 更新一个对象
     * @param t
     */
    void update(T t);

    /**
     * 通过id获取一个对象
     * @param id
     * @return
     */
    T getById(Serializable id);

    /**
     * 获取所有对象
     * @return
     */
    List<T> getAll();

    /**
     * 分页列表
     * @param query
     * @return
     */
    PageList<T> query(BaseQuery query);
}
