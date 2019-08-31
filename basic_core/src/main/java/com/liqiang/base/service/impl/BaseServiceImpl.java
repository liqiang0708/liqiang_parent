package com.liqiang.base.service.impl;

import com.liqiang.base.mapper.BaseMapper;
import com.liqiang.base.query.BaseQuery;
import com.liqiang.base.service.IBaseService;
import com.liqiang.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

//不需要加@Service,这里没有具体执行，子类继承时自己@service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    //    @Transactional(readOnly = false,propagation = Propagation.REQUIRED)
    @Transactional
    @Override
    public void add(T t) {
        baseMapper.save(t);
//        int i = 1/0;
    }

    @Transactional
    @Override
    public void del(Serializable id) {
        baseMapper.remove(id);
    }
    @Transactional
    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public T getById(Serializable id) {
        return baseMapper.loadById(id);
    }

    @Override
    public List<T> getAll() {
        return baseMapper.loadAll();
    }

    @Override
    public PageList<T> query(BaseQuery query) {

        //方案1(不可行):直接通过mapper返回分页数据,mapper没有实现类(映射器),
        // 也就是在mapper.java不能PageList,继续往下走Mapper.xml,也就是不可行,一条sql不能获取两个值,而且还要封装对象
        //方案2:在service通过查询mapper提供查询总数和当前页数据方法获取两个参数后,进行Pagelist封
        //查询总数
        Long total = baseMapper.queryTotal(query);
        //查询当前页数据
        if (total==0){
            return new PageList<>();
        }
        List<T> rows = baseMapper.queryRows(query);
        return new PageList<>(total,rows);

    }
}
