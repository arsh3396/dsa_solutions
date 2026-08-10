package BinarySearch;

import java.util.*;

/*
    Idea:
        Intuition:
            - array's left part is sorted in ascending and right part is sorted in descending so we can use binary search.

        Idea:
            - edge cases:
                - only 1 element, then return that
                - arr[0] > arr[1] then return arr[0]
                - arr[n-1] > arr[n-2] then return arr[n-1]
            - take low = 1, high = n-2
            - loop until low <= high
            - find mid and check if it is peak index then return it.
            - to check for left part compare mid index element with mid - 1 element.
            - if mid is greater than peak is in right side because we are moving upwards then mid + 1
            - else we are in right side(downwards) then mid - 1;
            - and in last return -1;

        TC: O(log(n))
        SC: O(1)
 */

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;

        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid+1]) {
                return mid;
            }
            else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
