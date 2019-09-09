package com.wzh.tools.utils.dataresult;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author vc
 */

public class PageEntity<T> {
    //总页数
    private int totalPages;
    //总行数
    private int totalRows;
    //当前页
    private int currentPage;
    //每页最大行数
    private int rows;
    //数据列表
    private List<T> list;

    public PageEntity() {

    }

    /**
     * 一次查出全部的数据
     *
     * @param list 全部数据
     */
    public PageEntity(List<T> list) {
        this.list = list;
        int trows = 0;
        if (!CollectionUtils.isEmpty(this.list)) {
            trows = this.list.size();
        }
        this.currentPage = 1;
        this.rows = trows;
        this.totalRows = trows;
        this.totalPages = 1;
    }

    public PageEntity(String error) {
        this.currentPage = 1;
        this.rows = 0;
        this.totalRows = 0;
        this.totalPages = 1;
        this.list = Collections.emptyList();
    }

    /**
     * @param currentPage 当前页
     * @param rows        每页最大行数
     * @param totalRows   总行数
     * @param list        当前数据列表
     */
    public PageEntity(int currentPage, int rows, int totalRows, List<T> list) {
        this.currentPage = currentPage;
        this.rows = rows;
        this.totalRows = totalRows;
        this.list = list;
        int tp = 1;
        if (this.totalRows > 0) {
            tp = (int) Math.ceil(this.totalRows / (this.rows * 1.0));
        }
        this.totalPages = tp;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.ceil(1 / (1 * 1.0)));
    }
}
