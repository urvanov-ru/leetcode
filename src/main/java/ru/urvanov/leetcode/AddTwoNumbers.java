package ru.urvanov.leetcode;

import java.math.BigInteger;

/**
 * Solves 
 * <a href = "https://leetcode.com/problems/add-two-numbers/">
 * Add Two Numbers
 * </a> problem
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        BigInteger value1 = BigInteger.ZERO;
        BigInteger value2 = BigInteger.ZERO;
        
        value1 = listNodeToBigInteger(currentNode1);
        value2 = listNodeToBigInteger(currentNode2);
        
        BigInteger result = value1.add(value2);
        
        return bigIntegerToListNode(result);
    }

    private BigInteger listNodeToBigInteger(ListNode listNode) {
        StringBuilder resultBuilder = new StringBuilder();
        for (ListNode currentNode = listNode; currentNode != null; 
                currentNode = currentNode.next) {
            resultBuilder.insert(0, currentNode.val);
        }
        return new BigInteger(resultBuilder.toString());
    }

    private ListNode bigIntegerToListNode(BigInteger bigInteger) {
        if (bigInteger == null) throw new IllegalStateException(
                "Parameter must not be null");
        if (bigInteger.compareTo(BigInteger.TEN) < 0) {
            return new ListNode(bigInteger.intValue());
        }
        
        BigInteger[] divideAndRemainder = bigInteger.divideAndRemainder(
                BigInteger.TEN);
        
        ListNode result = new ListNode(divideAndRemainder[1].intValue()),
                currentNode = result;
        BigInteger current = divideAndRemainder[0];
        while (current.compareTo(BigInteger.ZERO) > 0) {
            divideAndRemainder = current.divideAndRemainder(BigInteger.TEN);
            currentNode.next = new ListNode(
                    divideAndRemainder[1].intValue());
            currentNode = currentNode.next;
            current = divideAndRemainder[0];
        }
        return result;
    }
}
