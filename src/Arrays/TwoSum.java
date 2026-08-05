package Arrays;

import java.util.*;
import java.io.*;

/*
    Brute Force:
    Idea:
        - use two nested loops to iterate over all possible pairs
        - find if any pair's sum equals to target if any pair's sum equals to target return their index
        - outside loop return {-1, -1} that means any pair's sum is not equal to target

    TC: O(n^2)
    SC: O(1)

    Optimal:
    Intuition:
        - we can use hashmap to store the previously seen elements.

    Idea:
        - take one hashmap of key as int and value as int.
        - iterate over array.
        - for every element find the required sum.
        - if required sum is present in array return the index of both element
        - outside array return {-1, -1}

    TC: O(n)
    SC: O(n)

 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            else {
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}