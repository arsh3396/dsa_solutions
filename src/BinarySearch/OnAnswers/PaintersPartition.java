
package BinarySearch.OnAnswers;
import java.util.*;
import java.io.*;

/*
    - we have to find minimum time it takes to paint to all the walls using at max k painters.
    - for this low will be max of the array because one board can be paint by only one painter.
    - and high will be sum of the array because one can also paint all boards.

    Brute Force:
        Idea :
            - low = maxOfArray, high = sumOfArray
            - iterate low to high
            - for every i check is possible to paint all board using at max k painter.
            - when find the first possible return it.

        TC: O((sum - max) * n)
        SC: O(1)

    Optimal:
        Idea:
            - we can use binary search.
            - low = maxOfArray, high = sumOfArray, ans = -1
            - loop until low <= high
            - find mid and check if it is possible
                - if possible then high = mid - 1 and ans = mid
                - else low = mid + 1
            - and in last return ans

        TC: O(log(sum - max) * n)
        SC: O(1)
 */

public class PaintersPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        sc.close();
    }

    public int minTime(int[] arr, int k) {
        // code here
        int max = arr[0], sum = 0;
        for (int i : arr) {
            max = Math.max(max, i);
            sum += i;
        }

        int low = max, high = sum, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] arr, int k, int limit) {
        int sum = 0, count = 1;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= k) {
                sum += arr[i];
            }
            else {
                count++;
                sum = arr[i];
            }
        }

        return count <= limit;
    }
}
