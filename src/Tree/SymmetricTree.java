package Tree;

import java.util.*;

/*
    Idea:
        - in this question we can consider left subtree and right subtree as separate trees.
        - make one recursive function that takes two nodes as input.
        - if both nodes are null then return true.
        - if one of them is null or both node's data is not same then return false.
        - then call recursive function for first's left and second's right
        - and call recursive function again for first's right and second's left
        - return both the call.

    TC: O(n)
    SC: O(h)
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetry(root.left, root.right);
    }

    boolean symmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return symmetry(left.left, right.right) && symmetry(left.right, right.left);
    }
}
