package com.hospital.adapt.model.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPage<T> {
    private Integer pageNum = 1;
    private Integer pageSize = 30;
    private Long total = 0L;
    private List<T> rows = null;
    private Map<String, Object> params = new HashMap<String, Object>();

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total2) {
        this.total = total2;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

}
