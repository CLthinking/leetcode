package com.uestc.fft;

public class Util {
    private static double pi = Math.PI;

    private static double sin(double a) {
        return Math.sin(a);
    }

    private static double cos(double a) {
        return Math.cos(a);
    }


    public static Complex expj(double d){
        return new Complex().setX(cos(d)).setY(sin(d));
    }

    public static Complex W (int N, int k) {
        return expj(- 2 * pi * k / N);
    }


    public static Complex multiply(Complex a, Complex b) {
        return new Complex().setX(a.getX() * b.getX() - a.getY() * b.getY())
                .setY(a.getX() * b.getY() + a.getY() * b.getX());
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex().setX(a.getX() + b.getX())
                .setY(a.getY() + b.getY());
    }

    public static Complex minux(Complex a, Complex b) {
        return new Complex().setX(a.getX() - b.getX())
                .setY(a.getY() - b.getY());
    }

    public static boolean isPowOfTwo(int num) {
        return (num & num - 1) == 0;
    }

    public static boolean isNotPowerOfTwo(int num) {
        return !isPowOfTwo(num);
    }

    public static void main(String[] args) {
        System.out.println(sin(- pi / 2));
    }
}
