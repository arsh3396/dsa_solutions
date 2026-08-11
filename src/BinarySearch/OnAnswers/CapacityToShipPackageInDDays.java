package BinarySearch.OnAnswers;

import java.util.*;
import java.io.*;

/*
    - we have to find the minimum capacity of the ship so we can ship all the package in at max d days.
    - we must have to ship one package in one day only. We can't divide the package between 2 days or more.
    - so low will be maximum of array.
    - and high will be sum of array.

    Brute Force:
        Idea:
            - low = maxOfArray, high = sumOfArray
            - iterate from low -> high
            - when we find first possible capacity we will return the answer because we want to minimize the boat capacity.

        TC: O((sum - max) * n)
        SC: O(1)

    Optimal:
        Idea:
            - we can use binary search on answer.
            - low = maxOfArray, high = sumOfArray, ans = -1
            - loop until low <= high
            - find mid and check if that much capacity is possible to ship all package in at max d days.
                - if possible then ans = mid and high = mid - 1
                - else low = mid + 1
            - at last return ans

        TC: O(log(sum - max) * n)
        SC: O(1)
 */

public class CapacityToShipPackageInDDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int leastWeightCapacity(ArrayList<Integer> arr, int D) {
        // code here
        int max = arr.get(0), sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(max, arr.get(i));
            sum += arr.get(i);
        }

        int low = max, high = sum, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid, D)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(ArrayList<Integer> list, int capacity, int maxDays) {
        int sum = 0, days = 1;

        for (int i = 0; i < list.size(); i++) {
            if (sum + list.get(i) <= capacity) {
                sum += list.get(i);
            }
            else {
                days++;
                sum = list.get(i);
            }
        }

        return days <= maxDays;
    }
}
