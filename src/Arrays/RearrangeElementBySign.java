package Arrays;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - take two extra array, positive and negaive.
            - take two pointer, one for positive and one for negaive
            - iterate over original array
            - if index is even put positive's element and increase positive's pointer.
            - else put negative's element and increase negative's pointer.
            - in this approch we are traversing two times

        TC: O(n)
        SC: O(n)

    Optimal:
        Idea:
            - take one extra array(because we have to maintain the original order of numbers)
            - take p1 = 0, p2 = 1
            - if number is positive put it at p1 index and increase p1 by 2.
            - else put it at p2 index and increase p2 by 2.
        TC: O(n)
        SC: O(n)
 */

public class RearrangeElementBySign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int[] rearrangeArray(int[] nums) {
        int[] temp = new int[nums.length];
        int positiveIndex = 0, negativeIndex = 1;

        for (int i : nums) {
            if (i > 0) {
                temp[positiveIndex] = i;
                positiveIndex += 2;
            }
            else if (i < 0) {
                temp[negativeIndex] = i;
                negativeIndex += 2;
            }
        }

        return temp;
    }
}
