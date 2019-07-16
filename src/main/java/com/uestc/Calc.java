package com.uestc;

public class Calc {

    private static double score(int paperScore, int finalScore) {
        return (finalScore - paperScore * 0.6) / 0.4;
    }

    public static void main(String[] args) {
        System.out.println(finalSocre(96, 93));
    }

    private static double finalSocre(int paperSocre, int socre) {
        return paperSocre * 0.6 + socre * 0.4;
    }
}
