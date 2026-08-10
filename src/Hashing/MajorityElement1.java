package Hashing;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - use frequency array and iterate over the array and count frequency of every number.
            - iterate over the frequency array and find the number which has frequency 1 and return
            - else return -1

        TC: O(n)
        SC: O(n)

     Optimal(Moore's Voting Algotithem) :
        Idea:
            - take count and ele variable
            - iterate over array
            - if count is 0 then take ele = current element and count = 1
            - if current element is same as ele then increase count
            - else decrease count

            - after that again iterate on array count frequency of ele.
            - if it is grater than n/2 then return that element else -1

        TC: O(n)
        SC: O(1)

 */

public class MajorityElement1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int majorityElement(int[] nums) {
        int count = 0, element = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
            }
            else if (element == nums[i]) {
                count++;
            }
            else {
                count--;
            }
        }

        int freq = 0;
        for (int i : nums) {
            if (i == element) {
                freq++;
            }
        }

        if (freq > nums.length / 2) {
            return element;
        }

        return -1;
    }
}
