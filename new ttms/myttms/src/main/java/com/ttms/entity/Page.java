package com.ttms.entity;

/**
 * Created by hjh on 16-12-14.
 */
public class Page {

    private int pageNow = 1;            //当前页数
    private int pageSize = 10;          //每页显示数量
    private int totalcount;             //总记录个数
    private int totalPageCount;         //总页数
    private int startPos;               //开始位置
    private boolean hasFirst;           //是否有首页
    private boolean hasPre;             //是否有前一页
    private boolean hasNext;            //是否有下一页
    private boolean hasLast;            //是否有最后一页

    public Page(int totalcount, int pageNow){

        this.totalcount = totalcount;
        this.pageNow = pageNow;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getTotalPageCount() {

        totalPageCount = getTotalcount() / getPageSize();
        return (totalcount % pageSize == 0)?totalPageCount : totalPageCount+1;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPos() {

        return (pageNow - 1) * pageSize;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public boolean isHasFirst() {

        return (pageNow == 1)?false:true;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    public boolean isHasPre() {

        return   isHasFirst()?true:false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {

        return isHasLast()?true:false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasLast() {

        return (pageNow == getTotalPageCount())?false:true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }


}
