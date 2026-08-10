package BinarySearch;

import java.util.*;

/*
    Idea:
        - at any given one part of array will be always sorted.

        - use binary search because is array is sorted.
        - loop until left <= right
        - find middle if middle is equal to target return it.
        - if mid element is greater than low element then left part is sorted.
            - if element is in left part then high = mid - 1
            - else low = mid + 1
        - else right part is sorted
            - if element is in right part then low = mid + 1
            - else high = mid - 1;
        - at last return -1;

    TC: O(log(n))
    SC: O(1)
 */

public class SearchInSortedArray1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int search(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // if mid element equals to k return the mid
            if (nums[mid] == k) {
                return mid;
            }

            // checking if right half is sorted or not
            else if (nums[mid] <= nums[right]) {

                // if right half sorted and elment is in right half so search in right half
                if (nums[mid] <= k && k <= nums[right]) {
                    left = mid + 1;
                }
                // else search in left half
                else {
                    right = mid - 1;
                }
            }

            // left half sorted
            else {

                // if left sorted and element is in left half
                if (nums[left] <= k && k <= nums[mid]) {
                    right = mid - 1;
                }
                // else search in right half
                else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
