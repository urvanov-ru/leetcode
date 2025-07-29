package ru.urvanov.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solves
 * <a href = "https://leetcode.com/problems/number-of-islands/">
 * Number of Islands
 * </a>
 * problem.
 */
public class NumberOfIslands {
    private static final char ISLAND = '1';
    private static final char WATER = '0';
    private static final int PROCESSED = 2;
    
    private static final int DIRECTION_START = -1;
    private static final int DIRECTION_UP = 0;
    private static final int DIRECTION_RIGHT = 1;
    private static final int DIRECTION_DOWN = 2;
    private static final int DIRECTION_LEFT = 3;
    private static final int DIRECTION_END = 4;
    
    public int numIslands(char[][] grid) {
        if ((grid.length == 0) || (grid[0].length == 0)) {
            throw new IllegalArgumentException("Grid has invalid size.");
        }
        final int grid_width = grid.length;
        final int grid_height = grid[0].length;
        int[][] buf = new int[grid.length][grid[0].length];
        record StackItem(int x, int y, int direction){};
        Deque<StackItem> directions = new ArrayDeque<>();
        int result = 0;
        for (int x = 0; x < grid_width; x++) {
            for (int y = 0; y < grid_height; y++) {
                if (grid[x][y] == ISLAND && buf[x][y] != PROCESSED) {
                    result++;
                    
                    int direction = DIRECTION_START;
                    int n = x;
                    int m = y;
                    directions.addLast(new StackItem(x, y, DIRECTION_END));
                    while ((direction != DIRECTION_END)
                            || (!directions.isEmpty())) {
                        boolean retrieveFromStack = false;
                        if (grid[n][m] == WATER 
                                || ((buf[n][m] == PROCESSED)
                                        && (direction == DIRECTION_START))
                                || (direction == DIRECTION_END)) {
                            retrieveFromStack = true;
                        } else {
                            
                            switch (direction) {
                            case DIRECTION_START:
                                buf[n][m] = PROCESSED;
                                direction = DIRECTION_UP;
                                break;
                            case DIRECTION_UP:
                                if (m > 0) {
                                    directions.addLast(
                                            new StackItem(n, m, direction + 1));
                                    m--;
                                    direction = DIRECTION_START;
                                } else {
                                    direction++;
                                }
                                break;
                            case DIRECTION_RIGHT:
                                if (n < grid_width - 1) {
                                    directions.addLast(
                                            new StackItem(n, m, direction + 1));
                                    n++;
                                    direction = DIRECTION_START;
                                } else {
                                    direction++;
                                }
                                break;
                            case DIRECTION_DOWN:
                                if (m < grid_height - 1) {
                                    directions.addLast(
                                            new StackItem(n, m, direction + 1));
                                    m++;
                                    direction = DIRECTION_START;
                                } else {
                                    direction++;
                                }
                                break;
                            case DIRECTION_LEFT:
                                if (n > 0) {
                                    directions.addLast(
                                            new StackItem(n, m, direction + 1));
                                    n--;
                                    direction = DIRECTION_START;
                                } else {
                                    direction++;
                                }
                                break;
                            case DIRECTION_END:
                                retrieveFromStack = true;
                                break;
                            }
                        }
                        if ((retrieveFromStack) && (!directions.isEmpty())) {
                            StackItem fromStack = directions.removeLast();
                            n = fromStack.x();
                            m = fromStack.y();
                            direction = fromStack.direction();
                        }
                    }
                }
            }
        }
        return result;
    }

}
