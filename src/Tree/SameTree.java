package Tree;

import java.util.*;
import java.io.*;

/*
    Idea:
        - for this we have to check if two trees are same or not.
        - if p and q both are null then return true.
        - if one of them is null then return false.
        - if p and q's value is not same then return false.
        - and in last call recursive function for left subtree and right subtree for both tree.

    TC: O(n) -- total nodes
    SC: O(h) -- height of the tree
 */

public class SameTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
