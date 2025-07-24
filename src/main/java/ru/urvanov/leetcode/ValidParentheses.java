package ru.urvanov.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

/**
 * Solves
 * <a href = "https://leetcode.com/problems/valid-parentheses">
 * Valid Parentheses
 * </a>
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> braces = new ArrayDeque<>();
        
        Map<Character, Character> openCloseBraces = Map.of(
                '(', ')', '{', '}','[', ']');
        Set<Character> openBraces = openCloseBraces.keySet();
        Set<Character> closeBraces = Set.copyOf(openCloseBraces.values());
        for (int n = 0; n < s.length(); n ++) {
            char c = s.charAt(n);
            if (openBraces.contains(c)) {
                braces.add(c);
            }
            if (closeBraces.contains(c)) {
                if (braces.isEmpty()) {
                    return false;
                }
                Character lastBrace = braces.removeLast();
                if (!openCloseBraces.get(lastBrace).equals(c)) {
                    return false;
                }
            }
        }
        return braces.isEmpty();
    }
}
