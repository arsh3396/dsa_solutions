package SlidingWindow;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        - generate all subarray using 2 nested for loops and count how many of them are valid.
    Complexity:
        - Time Complexity: O(N * N) -- because we are using 2 nested loops.
        - Space Complexity: O(1)

    Optimal:
        - We can use sliding window approch because we are generating subarrays.
        - take 2 pointer: left = 0, right = 0
        - take sum variable to store sum of array
        - iterate until right is less then n
        - add current element into sum.
        - find length of current subarray.
        - check if current subarray is valid or not.
        - if valid then count how many subarray is ending at right index whose starting index is at most left.
        - if not valid decrease left until subarray is not valid.
        - after that count valid subarray once again.
        - increase right index.
        - return count at last.

    TC: O(N)
    SC: O(1)
 */

public class CountSubarrayWithScoreLessThenK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
}

class Solution {
    public long countSubarrays(int[] nums, long k) {

        long count = 0;

        int left = 0, right = 0, n = nums.length;
        long sum = 0;

        while (right < n) {
            sum += nums[right];

            int length = right - left + 1;

            if (sum * (long)length < k) {
                count += length;
            }
            else {
                while (sum * length >= k) {
                    sum -= nums[left++];
                    length--;
                }

                count += right - left + 1;
            }

            right++;
        }

        return count;
    }
}
