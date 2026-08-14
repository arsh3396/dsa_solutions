package Tree;

import java.util.*;
import java.io.*;

/*
    - we have to use backtracking.

    Idea:
        - make one nested list.
        - make one recursive function that has root, curr, target, list, ansList as parameters.
        - if root is null then return.
        - else add curr element to sum and list
        - check if current node is leaf node
            - if leaf node and curr == target then add list to ans list
        - call recursive function for left and right
        - at last remove element from list because we are using just one list.
        - we don't have to remove current element from sum because every element gets it's own sum copy

    TC: O(n^2) -- because n is for all nodes and in worst case every path sum is equals to target sum then we have to add every list to ans list.
    SC: O(h) -- height of array ignoring ans list space because it is used for storing the final ans.
 */

public class PathSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        pathSum(root, targetSum, 0, new ArrayList<>(), ans);

        return ans;
    }

    void pathSum(TreeNode root, int target, int curr, List<Integer> list, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        curr += root.val;
        list.add(root.val);

        if (root.left == null && root.right == null && curr == target) {
            ans.add(new ArrayList<>(list));
        }

        pathSum(root.left, target, curr, list, ans);
        pathSum(root.right, target, curr, list, ans);

        list.remove(list.size() - 1);
    }
}
