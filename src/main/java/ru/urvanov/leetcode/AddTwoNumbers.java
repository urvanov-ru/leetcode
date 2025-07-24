package ru.urvanov.leetcode;

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
        int buf = 0;
        ListNode result = new ListNode(-1);
        ListNode currentResultNode = result;
        while ((currentNode1 != null) && (currentNode2 != null)) {
            int sum = currentNode1.val + currentNode2.val + buf;
            buf = sum / 10;
            currentResultNode = currentResultNode.next = new ListNode(sum % 10);
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        
        ListNode currentNode;
        if (currentNode1 != null) {
            currentNode = currentNode1;
        } else if (currentNode2 != null) {
            currentNode = currentNode2;
        } else {
            currentNode = null;
        }
        
        // Iterate through the longest ListNode
        while (currentNode != null) {
            int sum = currentNode.val + buf;
            currentResultNode = currentResultNode.next = new ListNode(sum % 10);
            buf = sum / 10;
            currentNode = currentNode.next;
        }
        
        if (buf > 0) {
            currentResultNode = currentResultNode.next = new ListNode(buf);
        }
        return result.next;
    }

}
