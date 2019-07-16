package com.uestc.bytedance;

import java.util.Scanner;

/**
 * @author CLthinking
 * @date 2019/7/10 下午 12:10
 */
public class NO1 {

    public static String setRight(String str) {
       StringBuilder sb = new StringBuilder();
       char[] val = str.toCharArray();
        for (char c : val) {
            int len = sb.length();
            if (len >= 2 && c == sb.charAt(len - 1) && c == sb.charAt(len - 2)
                    || len >= 3 && c == sb.charAt(len - 1) && sb.charAt(len - 2) == sb.charAt(len - 3)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        cin.nextInt();

        while (cin.hasNext()) {
            System.out.println(setRight(cin.next()));
        }
    }
}
