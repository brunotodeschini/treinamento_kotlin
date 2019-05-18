package com.example.brunooliveira.extratorca.models;

import java.io.Serializable;

public class Limits implements Serializable {

    private String total_due;
    private String total;
    private String expent;
    private String available;

    public String getTotal_due() {
        return total_due;
    }

    public void setTotal_due(String total_due) {
        this.total_due = total_due;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getExpent() {
        return expent;
    }

    public void setExpent(String expent) {
        this.expent = expent;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
