package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchInRotatedSortedArrayTest {

    @Test
    void search_emptyArray() {
        SearchInRotatedSortedArray searchInRotatedSortedArray
                = new SearchInRotatedSortedArray();
        int actual = searchInRotatedSortedArray.search(new int[0], 2342345);
        int expected = -1;
        assertEquals(expected, actual);
    }
    
    static Stream<Arguments> search_oneItem_methodSource() {
        return Stream.of(
                arguments(-1, new int[] {1}, 3, "One item not found failed"),
                arguments(0, new int[] {3}, 3, "One item found failed"),
                arguments(-1, new int[] {1, 2}, 3, "Two items not found failed"),
                arguments(1, new int[] {1, 2}, 2, "Two items found failed"),
                
                // not rotated
                arguments(4, new int[] {1, 3, 4, 8, 10, 34}, 10,
                        "Not rotated found failed"),
                arguments(-1, new int[] {1, 3, 4, 8, 10, 34}, 11,
                        "Not rotated not found failed"),
                
                // rotated
                arguments(2, new int[] {4, 8, 10, 34, 1, 3}, 10,
                        "Rotated left found failed"),
                arguments(0, new int[] {10, 34, 1, 3, 4, 8}, 10,
                        "Rotated right found failed"),
                
                // rotated min bound target
                arguments(4, new int[] {4, 8, 10, 34, 1, 3}, 1,
                        "Rotated left min bound target found failed"),
                arguments(2, new int[] {10, 34, 1, 3, 4, 8}, 1,
                        "Rotated right min bound target found failed"),
                
                // rotated left bound target
                arguments(0, new int[] {4, 8, 10, 34, 1, 3}, 4,
                        "Rotated left min bound target found failed"),
                arguments(0, new int[] {10, 34, 1, 3, 4, 8}, 10,
                        "Rotated right min bound target found failed"),
                
                // rotated max bound target
                arguments(3, new int[] {4, 8, 10, 34, 1, 3}, 34,
                        "Rotated left max bound target found failed"),
                arguments(1, new int[] {10, 34, 1, 3, 4, 8}, 34,
                        "Rotated right max bound target found failed"),
                
                // rotated right bound target
                arguments(5, new int[] {4, 8, 10, 34, 1, 3}, 3,
                        "Rotated left right bound target found failed"),
                arguments(5, new int[] {10, 34, 1, 3, 4, 8}, 8,
                        "Rotated right right bound target found failed"),
                
                // rotated not found
                arguments(-1, new int[] {4, 8, 10, 34, 1, 3}, 11,
                        "Rotated left not found failed"),
                arguments(-1, new int[] {10, 34, 1, 3, 4, 8}, 11,
                        "Rotated right not found failed"),
                
                // rotated big target value not found
                arguments(-1, new int[] {4, 8, 10, 34, 1, 3}, 50,
                        "Rotated left big target not found failed"),
                arguments(-1, new int[] {10, 34, 1, 3, 4, 8}, 50,
                        "Rotated right big target not found failed"),
                
                // rotated big target value not found
                arguments(-1, new int[] {4, 8, 10, 34, 1, 3}, -4,
                        "Rotated left low target value not found failed"),
                arguments(-1, new int[] {10, 34, 1, 3, 4, 8}, -4,
                        "Rotated right low target value not found failed")
                );
    }
    
    @MethodSource("search_oneItem_methodSource")
    @ParameterizedTest
    void search_oneItem(int expected, int[] nums, int target, String failureMessage) {
        SearchInRotatedSortedArray searchInRotatedSortedArray
            = new SearchInRotatedSortedArray();
        int actual = searchInRotatedSortedArray.search(nums, target);
        assertEquals(expected, actual, () -> failureMessage);
    }

}
