package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import static  org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PascalTriangleTest {

    static Stream<Arguments> generateMethodSource() {
        return Stream.of(
                arguments(List.of(List.of(1)), 1),
                arguments(List.of(List.of(1), List.of(1, 1)), 2),
                arguments(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1)), 3),
                arguments(List.of(List.of(1), List.of(1,1), List.of(1,2,1), List.of(1,3,3,1), List.of(1,4,6,4,1)), 5)
                );
    }
    
    @ParameterizedTest
    @MethodSource("generateMethodSource")
    void generate(List<List<Integer>> expected, int numRows) {
        PascalTriangle p = new PascalTriangle();
        assertEquals(expected, p.generate(numRows));
    }

}
