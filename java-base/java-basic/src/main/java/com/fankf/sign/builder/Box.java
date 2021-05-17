package com.fankf.sign.builder;

public class Box {
    private String color;
    private double weight;
    private double high;
    private double length;

    private Box() {
    }

    public Box color(String color) {
        this.color = color;
        return this;
    }

    public Box weight(double weight) {
        this.weight = weight;
        return this;
    }

    public Box high(double high) {
        this.high = high;
        return this;
    }

    public Box length(double length) {
        this.length = length;
        return this;
    }


}
