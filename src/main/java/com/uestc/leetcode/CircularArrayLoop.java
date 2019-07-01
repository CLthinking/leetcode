package com.uestc.leetcode;

public class CircularArrayLoop {
    public boolean circularArrayLoop0(int[] nums) {
        if (nums.length == 1) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            // slow/fast pointer
            int j = i, k = getIndex0(i, nums);
            while (nums[k] * nums[i] > 0 && nums[getIndex0(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    // check for loop with only one element
                    if (j == getIndex0(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex0(j, nums);
                k = getIndex0(getIndex0(k, nums), nums);
            }
            // loop not found, set all element along the way to 0
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex0(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private int getIndex0(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }

    // 上面是Discuss区的，下面是自己理解了进行改写和优化后的版本
    public static boolean circularArrayLoop(int[] nums) {
        if (nums.length == 1) return false;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = i;
            // 如果一个数组里面只包含正整数，那么他一定会包含一个循环的
            // 这里使用了异或来判断是否相同符号不同于上面的乘法操作
            while ((nums[fast] ^ nums[i]) >= 0 && (nums[getIndex(fast, nums)] ^ nums[i]) >= 0) {
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
                if (slow == fast) {
                    if (slow == getIndex(fast, nums)) {
                        break;
                    }
                    return true;
                }
            }
            // 执行到这里说明，前面经历的路径不是循环，那么后面再进入到上面经历过路径都不可能是循环路径
            // 所以将上面经历过的路径全部置为0，这样下次遇到0(原数组中不包含0)后就可以直接进行下一轮判断了
            int idx = i;
            int val = nums[i];
            while ((nums[idx] ^ val) >= 0 && nums[idx] != 0) {
                int next = getIndex(idx, nums);
                nums[idx] = 0;
                idx = next;
            }
        }
        return false;
    }
    private static int getIndex(int i, int[] nums) {
        int N = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % N : N + (i + nums[i]) % N;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,-5};
        circularArrayLoop(nums);
    }
}
