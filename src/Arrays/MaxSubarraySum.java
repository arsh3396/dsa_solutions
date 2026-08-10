package Arrays;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - generate all subarray and find their sum and among them find the max sum

        TC: O(n2)
        SC: O(1)

    Optimal(Kadane's Algorithm):
        Idea:
           - take sum and max variable.
           - iterate over the array and add element into sum and update the max also.
           - if sum at any point is less than zero then make sum = 0.
           - and in last return max.

        TC: O(n)
        SC: O(1)
 */

public class MaxSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        return max;
    }
}
