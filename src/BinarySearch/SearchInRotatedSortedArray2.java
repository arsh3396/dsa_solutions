package BinarySearch;

import java.util.*;
import java.io.*;

/*
    Idea:
        - it is same as search in rotated sorted arrya but in this duplicates is also there.
        - low = 0, high = n-1
        - if mid equals to target return true
        - so there is edge case if low, mid and high element is same then we will just increase the low and decrease high
        - if arr[low] <= arr[mid](left part sorted)
            - then check if element is in left part, if it is there high = mid - 1
            - if not low = mid + 1
        - right part sorted
            - then check if element is in right part, if it is there low = mid + 1
            - else high = mid - 1
        - and in last return false

    TC: O(log(n))
    SC: O(1)

 */

public class SearchInRotatedSortedArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low +  (high - low) / 2;
            if (nums[mid] == k) {
                return true;
            }
            // edge case
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            // left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && k <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            // right sorted
            else {
                if (nums[mid] < k && k <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
