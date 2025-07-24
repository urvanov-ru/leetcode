package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidParenthesesTest {

    static Stream<Arguments> isValidMethodSource() {
        return Stream.of(
                arguments(true, "()"),
                arguments(true, "()[]{}"),
                arguments(false, "(]"),
                arguments(true, "([])"),
                arguments(false, "([)]")
                );
    }
    
    @MethodSource("isValidMethodSource")
    @ParameterizedTest
    void testIsValid(boolean expected, String s) {
        ValidParentheses validParentheses = new ValidParentheses();
        assertEquals(expected, validParentheses.isValid(s));
    }

}
