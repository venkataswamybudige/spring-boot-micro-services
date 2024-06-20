package com.venkat.microservices.limitsservice.bean;

public class Limits {
    private int minimum;
    private int maximum;

    public Limits() {
    }

    public Limits(int minumum, int maximum) {
        this.minimum = minumum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
