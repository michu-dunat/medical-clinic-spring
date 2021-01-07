package com.company.model;

public class DataReader {

    private String pesel;
    private String data;
    private boolean checkbox;

    public DataReader(){}
    public DataReader(String pesel, String data, boolean checkbox) {
        this.pesel = pesel;
        this.data = data;
        this.checkbox = checkbox;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setCheckbox(boolean hasPesel) {
        this.checkbox = hasPesel;
    }

    public boolean getCheckbox() {
        return checkbox;
    }

    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
