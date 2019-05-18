package com.example.brunooliveira.extratorca.models;

import java.io.Serializable;

public class Details implements Serializable {

    private int overdue_days;
    private String overdue_date;
    private String original_value;
    private String value_diff;
    private String total_value;
    private String store;

    public int getOverdue_days() {
        return overdue_days;
    }

    public void setOverdue_days(int overdue_days) {
        this.overdue_days = overdue_days;
    }

    public String getOverdue_date() {
        return overdue_date;
    }

    public void setOverdue_date(String overdue_date) {
        this.overdue_date = overdue_date;
    }

    public String getOriginal_value() {
        return original_value;
    }

    public void setOriginal_value(String original_value) {
        this.original_value = original_value;
    }

    public String getValue_diff() {
        return value_diff;
    }

    public void setValue_diff(String value_diff) {
        this.value_diff = value_diff;
    }

    public String getTotal_value() {
        return total_value;
    }

    public void setTotal_value(String total_value) {
        this.total_value = total_value;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
