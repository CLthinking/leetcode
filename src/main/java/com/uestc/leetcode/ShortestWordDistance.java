package com.uestc.leetcode;

/**
 * @author CLthinking
 * @date 2019/7/14 上午 10:24
 */
public class ShortestWordDistance {
    /**
     * LeetCode 付费
     * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
     *
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     *
     * Given word1 = “coding”, word2 = “practice”, return 3.
     * Given word1 = "makes", word2 = "coding", return 1.
     *
     * Note:
     * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     */

    public static int shortestDistance(String[] words, String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        if (word1.equals(word2)) {
            return 0;
        }
        int last1 = -1, last2 = -1;

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                res = Math.min(res, last2 == -1 ? Integer.MAX_VALUE : i - last2);
                last1 = i;
            } else if (words[i].equals(word2)) {
                res = Math.min(res, last1 == -1 ? Integer.MAX_VALUE : i - last1);
                last2 = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(words, "coding", "practice"));
        System.out.println(shortestDistance(words, "coding", "makes"));

    }
}
