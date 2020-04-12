package com.web.gamego.model;

public class SimplePagingVO {
    private int offset;
    private int limit;
    private int startPage;

    public int getStartPage() {
        if(this.offset==0 && this.limit==0)
            return 0;
        else
            return (this.offset-1) * this.limit;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getOffset() {
        if(this.offset==0)
            return 1;
        else
            return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getLimit() {
        if(limit==0)
            return 10;
        else
            return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

}
