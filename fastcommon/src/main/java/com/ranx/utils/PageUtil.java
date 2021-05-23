package com.ranx.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author ranx
 * @create 2019-02-11 23:33
 **/
public class PageUtil implements Serializable {
    //当前页
    private long total;
    //当前页记录
    private List rows;

    public PageUtil(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
