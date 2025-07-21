package ru.urvanov.leetcode;

public class SearchInRotatedSortedArray {
    
    public static final int NOT_FOUND = -1;
    
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        
        int start = 0;
        int end = nums.length;
        int length = end - start;
        int position = -1;
        
        while (length > 0) {
            position = start + length / 2;
            int num = nums[position];
            int startNum = nums[start];
            int endNum = nums[end - 1];
            
            boolean leftPartIsSorted = false;
            boolean rightPartIsSorted = false;
            
            if (startNum <= num) {
                leftPartIsSorted = true;
            }
            
            if (num <= endNum) {
                rightPartIsSorted = true;
            }
            
            if ((leftPartIsSorted) && (rightPartIsSorted)) {
                // Source array is not rotated. Start binary search.
                return searchSorted(nums, start, end, target);
            }
            
            // Left part binary search if it is sorted and the number is inside.
            if ((leftPartIsSorted) && (target >= startNum)
                    && (target <= num)) {
                return searchSorted(nums, start, end, target);
            }
            
            // Right part binary search if it is sorted and the number is inside
            if ((rightPartIsSorted) && (target >= num)
                    && (target <= endNum)) {
                return searchSorted(nums, start, end, target);
            }
            
            // We already searched in the sorted part..
            // We need to search in the not sorted part.
            if (!leftPartIsSorted) {
                end = position;
            } else if (!rightPartIsSorted) {
                start = position;
            } else {
                throw new IllegalArgumentException("Source array is wrong.");
            }
            length = end - start;
        }
        
        return NOT_FOUND;
    }
    
    /**
     * Binary search in a sorted array.
     * @param nums Sorted array of int.
     * @param start Start index (inclusive) inside nums.
     * @param end End index (exclusive) inside nums.
     * @param target A value to search in nums between start and end.
     * return -1 if not found index otherwise.
     */
    private int searchSorted(int[] nums, int start, int end, int target) {
        if (nums == null)
            throw new IllegalArgumentException("nums is null");
        if (end < start)
            throw new IllegalArgumentException("end cannot be less then start");
        if (start >= nums.length)
            throw new IllegalArgumentException(
                    "start greater or equal then nums.length");
        if (start < 0) throw new IllegalArgumentException("start is negative");
        if (end > nums.length)
            throw new IllegalArgumentException("end greater then nums.length");
        if (end < 0) throw new IllegalArgumentException("end is negative");
        
        if (start == end) return -1;
        if (start + 1 == end) return nums[start] == target ? start : -1;
        
        int length = end - start;
        int position = -1;
        while (length > 0) {
            position = start + length / 2;
            int num = nums[position];
            if (num > target) {
                end = position;
            } else if (num < target) {
                start = position + 1;
            } else {
                // Found
                end = start;
            }
            length = end - start;
        }
        if ((position >= 0) && (nums[position] == target)) {
            return position;
        }
        return -1;
    }
}
