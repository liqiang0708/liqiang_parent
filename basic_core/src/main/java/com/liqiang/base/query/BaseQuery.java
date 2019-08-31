package com.liqiang.base.query;

public class BaseQuery {
    //前台传后台的参数
    //当前页
    private Long page = 1L;
    //每页条数
    private Long pageSize = 10L;
    //做模糊查询用的关键字
    private String keywords;

    //通过当前也和每页条数，获取  起始页  getStart按javaBean规范可以在mapper里面用  #{start} 取到值
    public  Long getStart(){
        return (this.page-1)*pageSize;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
