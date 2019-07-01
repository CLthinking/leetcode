package com.uestc.leetcode;

class GuessGame {
    private int n = 10;
    int guess(int num){
        if (num > n) {
            return -1;
        } else if (num < n) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class GuessNumberHigherOrLower extends GuessGame{
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int num = guess(mid);
            if (num == 1) {
                lo = mid + 1;
            } else if (num == -1) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
