package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void testSearch() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int result = new BinarySearch().search(nums, target);
        assertEquals(-1, result);
    }

}
