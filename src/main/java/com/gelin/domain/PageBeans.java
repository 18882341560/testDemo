package com.gelin.domain;

import java.util.List;

public class PageBeans<T> {
    private List<T> list;
    private int currentPage;
    private int pageSize;
    private int totalPage;
    private int count;

    public PageBeans() {
    }

    public PageBeans(List<T> data, int currentPage, int size, int count) {
        this.list = data;
        this.currentPage = currentPage;
        this.pageSize = size;
        this.count = count;
        this.totalPage = count % size == 0 ? count / size : count / size + 1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean hasNextPage() {
        return currentPage < totalPage;
    }

    public boolean hasPrevPage() {
        return currentPage > 1;
    }
}
