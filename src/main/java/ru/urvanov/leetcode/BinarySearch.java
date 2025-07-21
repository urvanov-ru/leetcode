package ru.urvanov.leetcode;

/**
 * Solves
 * <a href = "https://leetcode.com/problems/binary-search/">
 * Binary Search</a> problem.
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int currentStart = 0;
        int currentEnd = nums.length;
        int currentLength = currentEnd - currentStart;
        int currentPosition = -1;
        while (currentLength > 0) {
            currentPosition = currentStart + currentLength / 2;
            int currentNum = nums[currentPosition];
            if (currentNum > target) {
                currentEnd = currentPosition;
            } else if (currentNum < target) {
                currentStart = currentPosition+1;
            } else {
                // English comments
                currentEnd = currentStart;
            }
            currentLength = currentEnd - currentStart;
        }
        if ((currentPosition >= 0) && (nums[currentPosition] == target)) {
            return currentPosition;
        }
        return -1;
    }
}
