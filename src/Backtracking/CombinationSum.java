package Backtracking;

import java.util.*;
import java.io.*;

/*
    - we can do this using standard backtracking.
    - make one recursive function.
    - if index greater then equals to array length or sum is greater than target sum then return.
    - if sum is equals to target sum then add the list to ans list.
    - we have two choice:
        - take the current element
            - add it to sum and list and call the recursive function
            - after recursive function call end remove the current element.
        - not takint the current element
            - call the recursive function.
 */

public class CombinationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        function(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    void function (int index, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index == arr.length) {
            return;
        }

        // not taking the index
        function(index + 1, arr, target, list, ans);

        // taking the index

        // add element to the list
        list.add(arr[index]);

        // explore possibilities with that
        function(index, arr, target - arr[index], list, ans);

        // now remove that element to explore next possibilities
        list.remove(list.size() - 1);
    }
}
