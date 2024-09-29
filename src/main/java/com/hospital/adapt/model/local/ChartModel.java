
package com.hospital.adapt.model.local;

import java.util.List;

public class ChartModel {
    private List<String> chartLegends = null;
    private String chartName = null;
    private List<String> chartCategory = null;
    private List<Object> chartData = null;
    private Integer total = 0;
    private List<Integer> markData = null;

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public List<String> getChartCategory() {
        return chartCategory;
    }

    public void setChartCategory(List<String> chartCategory) {
        this.chartCategory = chartCategory;
    }

    public List<Object> getChartData() {
        return chartData;
    }

    public void setChartData(List<Object> chartData) {
        this.chartData = chartData;
    }

    public List<String> getChartLegends() {
        return chartLegends;
    }

    public void setChartLegends(List<String> chartLegends) {
        this.chartLegends = chartLegends;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Integer> getMarkData() {
        return markData;
    }

    public void setMarkData(List<Integer> markData) {
        this.markData = markData;
    }
}
