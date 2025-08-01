package ru.urvanov.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves 
 * <a href = "https://leetcode.com/problems/pascals-triangle/">
 * Pascal's Triangle</a> problem.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n = 0; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (n > 0) {
                List<Integer> prevRow = result.get(n - 1);
                for (int m = 1; m < n; m++) {
                    row.add(prevRow.get(m - 1) + prevRow.get(m));
                }
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }
}
