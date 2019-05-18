package com.example.brunooliveira.extratorca.models;

import java.io.Serializable;
import java.util.ArrayList;


public class Data implements Serializable {

    private String name;
    private String total_overdue;
    private String total_due;
    private ArrayList<Installments> installments;
    private Limits limits;

    public ArrayList<Installments> getInstallments() {
        return installments;
    }

    public void setInstallments(ArrayList<Installments> installments) {
        this.installments = installments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal_overdue() {
        return total_overdue;
    }

    public void setTotal_overdue(String total_overdue) {
        this.total_overdue = total_overdue;
    }

    public String getTotal_due() {
        return total_due;
    }

    public void setTotal_due(String total_due) {
        this.total_due = total_due;
    }



    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }
}
