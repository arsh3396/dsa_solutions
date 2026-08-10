package LinkedList;

import java.util.*;
import java.io.*;

/*
    Idea:
        - take 3 variables : temp = head, nextNode = null and prev = null
        - edge case:
            - if linkedlist is empty return null
        - iterate over linkedlist until temp is not null
        - make nextnode = temp.next
        - now change temp's next to prev
        - now make prev to temp and temp = nextnode
        - and at last return prev

    TC: O(n)
    SC: O(1)
 */

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head, nextNode = null, prev = null;

        while (temp != null) {
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }

        return prev;
    }
}
