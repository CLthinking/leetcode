package com.uestc.leetcode;

public class DistributeCandiesToPeople {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 0;
        int idx = 0;
        int cur = 1;
        while (candies > 0) {
            res[idx++] += cur++;
            candies -= cur - 1;
            idx = idx == num_people ? 0 : idx;
        }
        if (candies < 0) {
            idx = idx == 0 ? num_people - 1 : idx - 1;
            res[idx] += candies;
        }
        return res;
    }

    public static void main(String[] args) {
        distributeCandies(60,4);
    }
}
