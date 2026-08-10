package TwoPointer;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - make all the pairs and count area of container and out of that find max area.
        TC: O(n2)
        SC: O(1)

    Optimal:
        Idea:
            - use two pointer approach.
            - take low = 0, high = n-1 and max = 0
            - loop until low < high
            - count the area of low and high and according to it update the max.
            - after that if left's value is less than right's value then increase left else decrease right
            - and in last return max.

        TC: O(n)
        SC: O(1)
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;

        while (left < right) {
            int sum = 0;
            if (height[left] == height[right]) {
                sum = (right - left) * height[left];
            }
            else {
                sum = (right - left) * Math.min(height[left], height[right]);
            }

            max = Math.max(max, sum);

            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return max;
    }
}
