package com.ranx.common.request;


public class QueryReq extends Request {

    private int pageIndex=1 ;
    private int pageSize=10 ;
    /**
     * 总记录数
     */
    private int total;

    //后台用
    private int offset;
    private int limit;

    public QueryReq()
    {}

    public QueryReq(int pageSize)
    {
        this.pageSize=pageSize;
    }

    /**
     * @return the pageIndex
     */
    public int getPageIndex() {
        if(pageIndex<0) {
            this.pageIndex = 1;
        }
        return pageIndex;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        if(pageIndex<=0) {
            offset = 0;
        }else {
            offset = (pageIndex - 1) * pageSize;
        }
        return offset;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        limit = this.pageSize;
        return limit;
    }



    //getter/setter
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

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
