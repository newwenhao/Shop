package com.reborn.shop.model;

/**
 * Created by Administrator on 2017/4/30.
 */
public class SystemContext {
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();

    public static ThreadLocal<Integer> getPageSize() {
        return pageSize;
    }

    public static void setPageSize(ThreadLocal<Integer> pageSize) {
        SystemContext.pageSize = pageSize;
    }

    public static ThreadLocal<Integer> getPageIndex() {
        return pageIndex;
    }

    public static void setPageIndex(ThreadLocal<Integer> pageIndex) {
        SystemContext.pageIndex = pageIndex;
    }

    public static ThreadLocal<Integer> getPageOffset() {
        return pageOffset;
    }

    public static void setPageOffset(ThreadLocal<Integer> pageOffset) {
        SystemContext.pageOffset = pageOffset;
    }
}
