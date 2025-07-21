package ru.urvanov.leetcode;

import java.util.Arrays;

/**
 * Solves
 * <a href = "https://leetcode.com/problems/single-number/">
 * Single number problem</a>. 
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^ y); 
    }
}
