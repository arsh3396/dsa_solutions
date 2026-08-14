package Tree;

import java.util.*;
import java.io.*;

/*
    - we can DFS for this problem.

    Idea:
        - make one recursive function that has root, currSum and target as parameters.
        - if root == null then return false.
        - else add current node's data to sum
        - then check if current node is leaf node and currSum == target.
            - if true then return true.
        - else check call recursive function for left and right child.

    TC: O(n) -- number of nodes
    SC: O(h) -- height of tree

 */

public class PathSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    boolean pathSum(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            return true;
        }

        return pathSum(root.left, target, sum) || pathSum(root.right, target, sum);
    }
}
