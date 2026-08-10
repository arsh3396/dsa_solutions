package BinarySearch;

import java.util.*;
import java.io.*;

/*
    Idea:
        - we can use binary search because it is sorted array.
        - edge case:
            - only 1 element, then return that
            - arr[0] != arr[1] then return arr[0]
            - arr[n-1] != arr[n-2] then return arr[n-1]
            - because here already given that only one element is single and every other element is in pair.
        - take low = 1, high = n-2
        - loop until low <= high
        - find mid and check if it is single or not, if it is single then return it
        - else check for left part
        - in left part pair's index will be (even, odd), so if mid is even check for next element else check for previous element.
        - if condition true then high = mid - 1
        - else low = mid + 1
        - and in last return -1

    TC: O(log(n))
    SC: O(1)
 */

public class SingleElementInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n-2] != nums[n-1]) return nums[n-1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // if mid is single
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }

            // left part
            if ((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            }
            // right part
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
