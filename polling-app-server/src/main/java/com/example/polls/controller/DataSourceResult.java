package com.example.polls.controller;

import java.util.List;
import java.util.Map;

public class DataSourceResult {
    private List<?> results;
    private long __count;


    public long getTotal() {
        return __count;
    }

    public void setTotal(long total) {
        this.__count = total;
    }

    public List<?> getData() {
        return results;
    }

    public void setData(List<?> data) {
        this.results = data;
        setTotal(data.size());
    }
//
//    public Map<String, Object> getAggregates() {
//        //..
//    }
//
//    public void setAggregates(Map<String, Object> aggregates) {
//        //.
//    }
}
