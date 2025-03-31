package ru.liga.dcs.leetcode;

import ru.liga.dcs.leetcode.domain.ListNode;

import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * <p>
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return createListFromNumber(getNumberFromList(l1).add(getNumberFromList(l2)));
    }

    private ListNode createListFromNumber(BigInteger number) {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        char[] chars = sb.reverse().toString().toCharArray();
        return createHeadNode(chars);
    }

    private ListNode createHeadNode(char[] chars) {
        ListNode result = new ListNode((getIntDigitFromChar(chars[0])));
        createNextNode(1, chars, result);
        return result;
    }

    private int getIntDigitFromChar(char c) {
        return c - '0';
    }

    private void createNextNode(int depth, char[] chars, ListNode l) {
        if (depth > chars.length - 1) {
            return;
        }
        l.next = new ListNode(getIntDigitFromChar(chars[depth]));
        createNextNode(depth + 1, chars, l.next);
    }

    private BigInteger getNumberFromList(ListNode l) {
        StringBuilder sb = new StringBuilder();
        getNodeDigits(l, sb);
        return new BigInteger(sb.reverse().toString());
    }

    private void getNodeDigits(ListNode l, StringBuilder sb) {
        sb.append(l.val);
        if (l.next != null) {
            getNodeDigits(l.next, sb);
        }
    }
}
