package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/15 上午 09:52
 */
public class StringCompression {

    public static int compress(char[] chars) {
        int idx = 0, cur = 0;
        while (cur < chars.length) {
            char currentChar = chars[cur];
            int count = 0;
            while (cur < chars.length && chars[cur] == currentChar) {
                cur++;
                count++;
            }
            chars[idx++] = currentChar;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[idx++] = c;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a','a' ,'b', 'b', 'a', 'a'}));
        for (int i = 35; i <= 126 ; i++) {
            System.out.print((char)i);
        }
    }
}
