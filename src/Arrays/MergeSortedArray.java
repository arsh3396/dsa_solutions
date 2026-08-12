package Arrays;

import java.util.*;

/*
    Brute Force:
        Idea:
            - take the extra temp array of size of n1 + n2
            - take l = 0, r = 0, i = 0
            - loop until l < n1 && r < n2
                - if a1[l] <= a2[r] then add a1[l] to the temp array and l++
                - else add a2[r] to temp array and r++;
                - and increase the i++;
            - now again loop until l < n1
                - add the a1[l] and increase l and i
            - now loop until r < n2
                - add the a2[r] and increase r and i

            - now iterate over temp array and put back every element back to a1 array

        TC: O(n1 + n2)
        SC: O(n1 + n2)

    Optimal:
        - we can reduce the space complexity
        - here given that a1 array's size is n1 + n2

        Idea:
            - take t1 = n1 - 1, t2 = n2 - 1, i = a1.length - 1
            - loop until t1 >= 0 && t2 >= 0
                - if a1[t1] >= a2[t2] then add a1[t1] at a1[i] and decrease n1
                - else add a2[t2] to a1[i] and decrease n2
                - decrease i
            - now again iterate until t1 >= 0
                - add a1[t1] and decrease t1 and i
            - now again iterate until t2 >= 0
                - add a2[t2] and decrease t2 and i

        TC: O(n1 + n2)
        SC: O(1)


 */

public class MergeSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int left = m-1, right = n-1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                nums1[index] = nums1[left];
                left--;
                index--;
            }
            else {
                nums1[index] = nums2[right];
                right--;
                index--;
            }
        }

        while (left >= 0) {
            nums1[index] = nums1[left];
            index--;
            left--;
        }

        while (right >= 0) {
            nums1[index] = nums2[right];
            index--;
            right--;
        }
    }
}
