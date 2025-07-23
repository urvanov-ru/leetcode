package ru.urvanov.leetcode;

/**
 * Solves
 * <a href = "https://leetcode.com/problems/two-sum/">
 * Two sum</a> problem.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        
        int n = 0;
        int m = 1;
        
        while (n < nums.length - 1) {
            m = n + 1;
            while (m < nums.length) {
                if (nums[n] + nums[m] == target) {
                    return new int[] {n, m};
                }
                m++;
            }
            n++;
        }
        throw new IllegalArgumentException(
                "Should be at least one solution.");
    }
}
