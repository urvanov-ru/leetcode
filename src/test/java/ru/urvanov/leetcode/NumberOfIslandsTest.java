package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberOfIslandsTest {

    static Stream<Arguments> numIslandsMethodSource() {
        return Stream.of(
                arguments(1, new char[][] {
                    {'1'},{'1'}
                }),
                arguments(1, new char[][] {
                    {'1', '1'}
                }),
                arguments(1, new char[][] {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }),
                arguments(3, new char[][] {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                       }),
                arguments(1, new char[][] {
                    {'1','1','1'},
                    {'0','1','0'},
                    {'0','1','0'}
                    })
                );
    }
    
    @MethodSource("numIslandsMethodSource")
    @ParameterizedTest
    void numIslands(int expected, char[][] grid) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        assertEquals(expected, numberOfIslands.numIslands(grid));
    }

}
