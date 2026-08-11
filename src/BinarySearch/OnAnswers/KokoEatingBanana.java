package BinarySearch.OnAnswers;

import java.util.*;
import java.io.*;

/*
    - here we need to find in how many hours koko can eat all bananas of the pile, so we have to decide minimum speed so that koko can all piles of banana.
    - if pile has less than k banana so koko can eat all in one hour but she need to wait for next hour to move next pile.
    - for example:
        - if pile contains 5 banana and eating speed is 3 banana/hour so to complete this pile koko needs 2 hour.

    Brute Force:
        - low will be 1 and high will be max of array because at max in one hour koko can eat only one pile.
        - loop from 1 to max.
        - find the isPossible for that i or not.
        - when you find first possible i then return it.

        TC: O(n * max(arr))
        SC: O(1)

    Optimal:
        - we can use binary search.
        - low = 1, high = arr(max)
        - take one variable ans = -1.
        - loop until low <= high
        - find mid and check isPossible(mid)
            - then ans = mid and high = mid - 1
            - else low = mid + 1
        - in last return ans
 */

public class KokoEatingBanana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int kokoEat(int[] arr, int k) {
        // code here
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }

        int low = 1, high = max, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid) <= k) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    int isPossible(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += Math.ceil((double)arr[i] / k);
        }

        return count;
    }
}
