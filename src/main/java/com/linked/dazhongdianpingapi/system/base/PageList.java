package com.linked.dazhongdianpingapi.system.base;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.List;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Data
public class PageList<T> {
    //数据集
    private List<T> data;
    //总条数
    private long total;
    //页码
    private int pageNum;
    //每页显示多少条
    private int pageSize;
    //总页数
    private int totalPages;

    public PageList(Page page){
        this.data = page.getResult();
        this.total = page.getTotal();
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.totalPages =(int)Math.ceil((double)page.getTotal()/page.getPageSize()) ;
        }


    public PageList(Page page, List<T> list){
        this.data = list;
        this.total = page.getTotal();
        this.pageNum = page.getPageNum();
        this.pageSize = page.getPageSize();
        this.totalPages =(int)Math.ceil((double)page.getTotal()/page.getPageSize()) ;
    }

}
