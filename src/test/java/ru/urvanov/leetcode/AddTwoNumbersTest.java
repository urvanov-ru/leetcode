package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.urvanov.leetcode.AddTwoNumbers.ListNode;

class AddTwoNumbersTest {

    static Stream<Arguments> addTwoNumbersMethodSource() {
        return Stream.of(
                arguments(new int[] {7, 0, 8} ,new int[] {2,4,3},
                        new int[] {5,6,4}),
                arguments(new int[] {8,9,9,9,0,0,0,1},
                        new int[] {9,9,9,9,9,9,9}, new int[] {9,9,9,9})
                ,
                arguments(new int[] {0}, new int[] {0}, new int[] {0}),
                arguments(new int[] {7, 0, 4, 0, 1}, new int[] {2, 4, 9}, new int[] {5, 6, 4, 9})
                );
    }
    
    @MethodSource("addTwoNumbersMethodSource")
    @ParameterizedTest
    void addTwoNumbers(int[] expectedValues, int[] firstListValues,
            int[] secondListValues) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode firstList = arrayToList(addTwoNumbers, firstListValues);
        ListNode secondList = arrayToList(addTwoNumbers, secondListValues);
        ListNode actual = addTwoNumbers.addTwoNumbers(firstList, secondList);
        assertArrayAndListNodeEquals(expectedValues,actual);
    }
    
    ListNode arrayToList(AddTwoNumbers addTwoNumbers, int[] arr) {
        if ((arr == null) || (arr.length == 0)) {
            throw new IllegalArgumentException(
                    "Array must be not null and not empty");
        }
        ListNode firstNode, lastNode;
        firstNode = lastNode = addTwoNumbers.new ListNode(arr[0]);
        for (int n = 1; n < arr.length; n++) {
            lastNode = lastNode.next = addTwoNumbers
                    .new ListNode(arr[n]);
        }
        return firstNode;
    }
    
    void assertArrayAndListNodeEquals(int[] expected, ListNode actual) {
        assertNotNull(expected);
        assertNotNull(actual);
        int n = 0;
        ListNode node = actual;
        while (node != null && n < expected.length) {
            assertEquals(expected[n], node.val,
                    "Answer in position " + n + " is different");
            node = node.next;
            n++;
        }
        assertEquals(expected.length, n, "Expected and actual lists have different length");
    }

}
