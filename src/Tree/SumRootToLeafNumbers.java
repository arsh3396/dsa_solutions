package Tree;

import java.util.*;
import java.io.*;

/*
    - we can do simple DFS for this problem

    Idea:
        - make one global variable as totalSum
        - make one recursive function that take root and currSum as parameters.
        - if root is null return.
        - Process Current Node: multiply currSum with 10 and add current node's value to currSum
        - Leaf Node Check:
            - if current node is leaf node add currSum to totalSum
        - Recurse:
            - call for left and right child.

    TC: O(n) -- number of nodes
    SC: O(h) -- height of tree.

 */

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
}

class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        nodeSum(root, 0);

        return total;
    }

    void nodeSum(TreeNode root, int curr) {
        if (root == null) {
            return;
        }

        curr = curr * 10 + root.val;

        if (root.left == null && root.right == null) {
            total += curr;
            return;
        }

        nodeSum(root.left, curr);
        nodeSum(root.right, curr);
    }
}
