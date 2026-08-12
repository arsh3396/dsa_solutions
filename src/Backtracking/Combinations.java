package Backtracking;

import java.util.*;
import java.io.*;

/*
    - this is standerd backtracking problem.
    - first make array from 1 to n.
    - now make one recursive function.
    - return condition will be when temp array's length is equals to k then add that array to as list in ans list.
    - if index is greater than or equal to array length then return.
    - so we have two choice now.
        - take current index.
            - then add current element into temp array.
            - now call the recursive function,
            - after recursive function ends remove current element from the array.
        - don't take the current element.
            - call the recursive function.
    - call this recursive function and return the final ans list.
 */

public class Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        combinations(1, arr, ans, new ArrayList<>(), k);

        return ans;
    }

    void combinations(int index, int[] arr, List<List<Integer>> ans, List<Integer> list, int k) {
        // if (index == arr.length)
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (index == arr.length) return;

        list.add(arr[index]);
        combinations(index+1, arr, ans, list, k);
        list.remove(list.size() - 1);

        combinations(index+1, arr, ans, list, k);
    }
}
