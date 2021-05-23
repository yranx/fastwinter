package com.ranx.common.result;


import java.io.Serializable;

public class PagingDto<T>  implements Serializable {

    private int  pageIndex;

    private int pageSize;

    private int total;

    private int pageCount;

    T  data;

    /**
     * @return the pageCount
     */
    public int getPageCount() {

        if (pageIndex > 0)
        {
            if (total % pageSize == 0)
            {
                pageCount = total / pageSize;
            }
            else
            {
                pageCount = total / pageSize + 1;
            }
        }
        return pageCount;
    }




    //getter/setter
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
