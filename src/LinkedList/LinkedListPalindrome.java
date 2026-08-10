package LinkedList;

import java.util.*;
import java.io.*;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
    public boolean isPalindrome(ListNode head) {
        // if linkedlist is empty or only contains one node
        if (head == null || head.next == null) {
            return true;
        }

        // finding middle of the linked list so we can reverse the second half of the linked list
        ListNode slow = head, fast = head;

        // here fast.next will come first because if linked list just have two nodes than fast.next.next condition will be met and our loop will never run.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing the second half
        ListNode newHead = reverse(slow.next);

        // left is at head, and right is at head of the second half
        ListNode left = head, right = newHead;

        while (right != null) {
            if (left.val != right.val) {

                // if value is not same we will reverse the second half of the linked list to make it original linked list and return false
                reverse(newHead);
                return false;
            }
            left = left.next;
            right = right.next;
        }

        // if it's a palindrome linked list we will revese the second half and return true
        reverse(newHead);
        return true;
    }

    ListNode reverse(ListNode point) {

        // this is same logic of reversing the whole singly linked list
        ListNode prev = null, nextNode = null, current = point;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
