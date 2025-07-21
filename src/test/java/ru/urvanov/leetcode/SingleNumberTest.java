package ru.urvanov.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingleNumberTest {

    @Test
    void test() {
        SingleNumber s = new SingleNumber();
        assertEquals(3, s.singleNumber(new int[] {2,5,3,5,2, -1, -1}));
    }

}
