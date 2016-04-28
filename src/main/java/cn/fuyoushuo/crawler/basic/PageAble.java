package cn.fuyoushuo.crawler.basic;

import java.io.Serializable;

/**
 * Created by MALIANG on 2015/10/29.
 */
public class PageAble implements Serializable{

    protected Integer page;

    protected Integer rows;

    protected Integer from;

    protected Integer total;

    protected String sort;

    protected String order;

    public int getPage() {
        if(this.page == null){
            return 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        if(this.rows == null){
          return 20;
        }
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getFrom() {
        return (this.getPage()-1)*this.getRows();
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
