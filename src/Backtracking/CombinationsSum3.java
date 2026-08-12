package Backtracking;

import java.util.*;
import java.io.*;

/*
    - we can do this using standard backtracking.
    - make one recursive function.
    - if sum is equals to target and temp list's length is equals to k then add temp list to ans list.
    - if ele is 10 then return.
    - we have two choice
        - take the current element.
            - add current element to sum and temp list and call the recursive function
            - remove the current element from the temp list
        - don't take the current element
            - call the recursive function for this
 */

public class CombinationsSum3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        combinations(k, 0, ans, new ArrayList<>(), n, 1);

        return ans;
    }

    void combinations(int k, int sum, List<List<Integer>> ans, List<Integer> list, int target, int ele) {
        if (sum == target && k == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (ele == 10) {
            return;
        }

        // taking the current element
        list.add(ele);
        combinations(k, sum + ele, ans, list, target, ele + 1);
        list.remove(list.size() - 1);

        // not taking the current element
        combinations(k, sum, ans, list, target, ele + 1);
    }
}
