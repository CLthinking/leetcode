package com.uestc.leetcode;

public class RansomNote {
    public boolean canConstruct0(String ransomNote, String magazine) {
        int[] hashNote = new int[26];
        char[] chars = ransomNote.toCharArray();
        for (char c : chars) hashNote[c - 'a']++;
        chars = magazine.toCharArray();
        for (char c : chars) hashNote[c - 'a']--;
        for (int n : hashNote) {
            if (n > 0) return false;
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hashNote = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) hashNote[c - 'a']++;
        chars = ransomNote.toCharArray();
        for (char c : chars) {
            if (--hashNote[c - 'a'] < 0) return false;
        }
        return true;
    }
}
