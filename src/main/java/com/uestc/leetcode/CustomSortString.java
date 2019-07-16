package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/15 上午 09:42
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder();
        char[] Tval = T.toCharArray();
        for (char c : Tval) {
            map[c - 'a']++;
        }
        char[] Sval = S.toCharArray();
        for (char c : Sval) {
            while (map[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();

    }
}
