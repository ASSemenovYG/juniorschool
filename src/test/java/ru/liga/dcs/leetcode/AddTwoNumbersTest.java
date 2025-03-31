package ru.liga.dcs.leetcode;

import org.junit.jupiter.api.Test;
import ru.liga.dcs.leetcode.domain.ListNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        ListNode one_three = new ListNode(3);
        ListNode one_two = new ListNode(4,one_three);
        ListNode one_one = new ListNode(2, one_two);

        ListNode two_three = new ListNode(4);
        ListNode two_two = new ListNode(6,two_three);
        ListNode two_one = new ListNode(5, two_two);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode result = addTwoNumbers.addTwoNumbers(one_one, two_one);
        assertThat(result.val).isEqualTo(7);
        assertThat(result.next.val).isEqualTo(0);
        assertThat(result.next.next.val).isEqualTo(8);
        assertThrows(NullPointerException.class, () ->
        {
            var next = result.next.next.next.next;
        });
    }

    @Test
    void addTwoNumbers_9999999991() {
        ListNode one_one = new ListNode(9);

        ListNode two_10 = new ListNode(9);
        ListNode two_9 = new ListNode(9, two_10);
        ListNode two_8 = new ListNode(9, two_9);
        ListNode two_7 = new ListNode(9, two_8);
        ListNode two_6 = new ListNode(9, two_7);
        ListNode two_5 = new ListNode(9, two_6);
        ListNode two_4 = new ListNode(9, two_5);
        ListNode two_three = new ListNode(9, two_4);
        ListNode two_two = new ListNode(9,two_three);
        ListNode two_one = new ListNode(1, two_two);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode result = addTwoNumbers.addTwoNumbers(one_one, two_one);
//        assertThat(result.val).isEqualTo(7);
//        assertThat(result.next.val).isEqualTo(0);
//        assertThat(result.next.next.val).isEqualTo(8);
//        assertThrows(NullPointerException.class, () ->
//        {
//            var next = result.next.next.next.next;
//        });
        //2147483647
        //9999999991
    }
}