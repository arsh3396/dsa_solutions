package Arrays;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - we can iterate on array and count 0, 1 and 2.
            - we again iterate on array and put them back.

        TC: O(n)
        SC: O(1)

    Optimal:
        Idea:
            - take 3 variables: left = 0, mid = 0, end = n-1
            - iterate while mid <= right
            - if mid is 0, then swap with left and increase left and mid
            - if mid is 2, then swap with right and decrease right
            - else increase mid

        TC: O(n)
        SC: O(1)


 */

public class Sort123 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public void sortZeroOneTwo(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while(mid <= right) {
            if (nums[mid] == 0) {
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            }
            else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
            else {
                mid++;
            }
        }
    }
}
