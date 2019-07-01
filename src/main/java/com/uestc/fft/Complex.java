package com.uestc.fft;

public class Complex {
    private double x;
    private double y;

    public Complex(double x, double y) {this.x = x; this.y = y;}
    public Complex() {this(0,0);}


    @Override
    public String toString() {
        if (y > 0 && y != 1) {
            return String.format("%.4f + %.4fi",x, y);
        } else if (y < 0 && y != -1) {
            return String.format("%.4f - %.4fi",x, Math.abs(y));
        } else if (y == 1) {
            return String.format("%.4f + i",x);
        } else if (y == -1) {
            return String.format("%.4f - i",x);
        } else { // y = 0
            return String.format("%.4f",x);
        }

    }

    public double getX() {
        return x;
    }

    public Complex setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Complex setY(double y) {
        this.y = y;
        return this;
    }
}
