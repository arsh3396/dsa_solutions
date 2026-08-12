package Tree;

import java.util.*;
import java.io.*;

/*
    Idea:
        - make one recursive function
        - if root is null return 0
        - call recursive function for the left child and assign that to left
        - now call recursive function for the right child and assign that to right
        - return 1 + max(left, right)

    TC: O(n) -- n is number of node
    SC: O(h) -- h is height of tree
 */

public class MaximumDepthOfBT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int maxDepth(TreeNode root) {
        //your code goes here
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
