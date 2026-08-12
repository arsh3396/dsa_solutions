package Tree;

import java.util.*;
import java.io.*;

/*
    Idea:
        - make one recursive function
        - if root is null then return null
        - using temp variable swap the left and right node
        - call the recursive function for left child
        - call the recursive function for right child
        - at last return root

    TC: O(n)
    SC: O(h)
 */

public class InvertBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
