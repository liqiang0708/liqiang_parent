package com.liqiang.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据返回
 * @param <T>
 */
public class PageList<T> {

    //总数
    private Long total = 0L;

    //当前页数据
    private List<T> rows = new ArrayList<T>();

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageList() {
    }

    public PageList(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
