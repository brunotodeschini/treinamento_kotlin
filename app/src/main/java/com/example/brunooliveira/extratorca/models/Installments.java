package com.example.brunooliveira.extratorca.models;

import java.io.Serializable;

public class Installments implements Serializable {

    private String past_due;
    private String carnet;
    private String installment;
    private String value;
    private Details detail;


    public String getPast_due() {
        return past_due;
    }

    public void setPast_due(String past_due) {
        this.past_due = past_due;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Details getDetail() {
        return detail;
    }

    public void setDetail(Details detail) {
        this.detail = detail;
    }
}
