package LinkedList;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - iterate over linkedlist and count total nodes
            - now again iterate over linkedlist and return the middle node.
        TC: O(n)
        SC: O(n)

    Optimal:
        Idea:
            - take two pointer: slow = head, fast = head
            - loop until fast != null && fast.next != null
            - move slow pointer only one node and fast pointer two nodes in one iteration.
            - after loop return slow.
        TC: O(n/2)
        SC: O(1)
 */

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public ListNode middleOfLinkedList(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
