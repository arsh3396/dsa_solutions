package Arrays;

import java.util.*;
import java.io.*;

/*
    Brute Force:
        Idea:
            - we can make number to string and make that string reverse and compare that string.
            - based on that return true/false

        TC: O(n)
        SC: O(n)

    Optimal:
        Intution:
            - we can make reverse number.

        Idea:
            - take a number temp = 0
            - we can take modulo of number with 10 and store it in rem
            - multiply temp with 10 and add rem
            - divide number with 10

        TC: O(n)
        SC: O(1)
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int dup = x;
        int sum = 0;
        while (dup > 0) {
            int rem = dup % 10;
            sum = (sum * 10) + rem;
            dup /= 10;
        }
        return x == sum;
    }
}