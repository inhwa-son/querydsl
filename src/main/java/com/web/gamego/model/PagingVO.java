package com.web.gamego.model;

public class PagingVO {

    public PagingVO(Long listCnt, int offset, int limit){

        setOffset(offset);
        setListCnt(listCnt);
        setLimit(limit);

        setPageCnt(listCnt);
        setRangeCnt(pageCnt);
        rangeSetting(offset);

        setStartIndex(offset);
    }


    private int limit = 10;

    private int rangeSize = 10;

    private int offset = 1;

    private int curRange = 1;

    private Long listCnt;

    private int pageCnt;

    private int rangeCnt = 10;

    private int startPage = 1;

    private int endPage = 1;

    private int startIndex = 0;

    private int prevPage;

    private int nextPage;

    public void setPageCnt(Long listCnt) {
        this.pageCnt = (int) Math.ceil(listCnt*1.0/limit);
    }
    public void setRangeCnt(int pageCnt) {
        this.rangeCnt = (int) Math.ceil(pageCnt*1.0/rangeSize);
    }
    public void rangeSetting(int offset){

        setCurRange(offset);
        this.startPage = (curRange - 1) * rangeSize + 1;
        this.endPage = startPage + rangeSize - 1;

        if(endPage > pageCnt){
            this.endPage = pageCnt;
        }

        this.prevPage = offset - 1;
        this.nextPage = offset + 1;
    }
    public void setCurRange(int offset) {
        this.curRange = (int)((offset-1)/rangeSize) + 1;
    }
    public void setStartIndex(int offset) {
        this.startIndex = (offset-1) * limit;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getRangeSize() {
        return rangeSize;
    }
    public void setRangeSize(int rangeSize) {
        this.rangeSize = rangeSize;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public Long getListCnt() {
        return listCnt;
    }
    public void setListCnt(Long listCnt) {
        this.listCnt = listCnt;
    }
    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getCurRange() {
        return curRange;
    }
    public int getPageCnt() {
        return pageCnt;
    }
    public int getRangeCnt() {
        return rangeCnt;
    }
    public int getStartIndex() {
        return startIndex;
    }


}
