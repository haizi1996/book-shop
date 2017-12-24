package com.book.dto;

import java.util.List;

public class PageHelperResult<T>  extends AbstractResult{

    private Integer pagenum;//当前页码
    private Integer pagesize=3;//每页显示的条数
    private Integer totalrecords;//总记录数
    private Integer totalpage;//总页数
    private Integer startindex;//每页开始的索引

    private List<T> data;



    public PageHelperResult(boolean state, String errorMess) {
        this.state = state;
        this.errorMess = errorMess;
    }

    public PageHelperResult(boolean state, List<T> data  ) {
        this.state = state;
        this.data = data;
    }

    public PageHelperResult initPage(Integer pageNum , Integer totalNum ){

        return this;
    }


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "BaseResult{" +
                "data=" + data +
                ", state=" + state +
                ", errorMess='" + errorMess + '\'' +
                '}';
    }

    public static<T> AbstractResult success(List<T> t){
        return new PageHelperResult<T>(true , t);
    }

    public static AbstractResult error(String errorMess){
        return new PageHelperResult(false, errorMess);
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(int totalrecords) {
        this.totalrecords = totalrecords;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getStartindex() {
        return startindex;
    }

    public void setStartindex(int startindex) {
        this.startindex = startindex;
    }
}
