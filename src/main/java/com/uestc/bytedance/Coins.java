package com.uestc.bytedance;

import java.util.Scanner;

public class Coins {
    public int coins(int val) {
        int num = 1024 - val;
        return (num >> 6) + ((num & 0x30) >> 4) + ((num & 0xc) >> 2) + (num & 0x3);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        num = 1024 - num;
        num = (num >> 6) + ((num & 0x30) >> 4) + ((num & 0xc) >> 2) + (num & 0x3);
        System.out.println(num);
    }
}
