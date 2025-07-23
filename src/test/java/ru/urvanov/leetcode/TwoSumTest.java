package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoSumTest {

    static Stream<Arguments> twoSumMethodSource() {
        return Stream.of(
                arguments(new int[] {0, 1}, new int[] {2,7,11,15}, 9),
                arguments(new int[] {1, 2}, new int[] {3,2,4}, 6),
                arguments(new int[] {0, 1}, new int[] {3,3}, 6)
                );
    }
    
    @MethodSource("twoSumMethodSource")
    @ParameterizedTest
    void twoSum(int[] expected, int[] nums, int target) {
        TwoSum twoSum = new TwoSum();
        int[] actual = twoSum.twoSum(nums, target);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

}
