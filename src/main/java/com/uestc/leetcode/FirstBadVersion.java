package com.uestc.leetcode;

import java.security.SecureRandom;

class VersionControl{
    private static int firstBadVersion = 4;
    static boolean isBadVersion(int version){
        return version >= firstBadVersion;
    }
}

public class FirstBadVersion extends VersionControl{
    public static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;  // 这里不能写成 hi - (hi - lo) / 2
            if (isBadVersion(mid)) {
                hi = mid;  // mid可能就是firstBadVersion，所以这里不是 hi = mid - 1 了。
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    public static void main(String[] args) {
        firstBadVersion(5);
    }

}
