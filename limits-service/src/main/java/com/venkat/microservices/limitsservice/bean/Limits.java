package com.venkat.microservices.limitsservice.bean;

public class Limits {
    private int minumum;
    private int maximum;

    public Limits() {
    }

    public Limits(int minumum, int maximum) {
        this.minumum = minumum;
        this.maximum = maximum;
    }

    public int getMinumum() {
        return minumum;
    }

    public void setMinumum(int minumum) {
        this.minumum = minumum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
