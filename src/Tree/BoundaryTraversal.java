package Tree;

import java.util.*;
import java.io.*;

/*
    - to do boundary traversal we will follow left -> leaves -> right

    Idea:
        - isLeaf:
            - will return if node is leaf node or not

        - make one list in boundary function
        - check if root is null then return empty list
        - if root is not leaf node then add it's value to list

        - left traversal:
            - in this function we will go as left as possible without adding leaves
            - take curr = root.left
            - loop until curr is not null
            - curr node is not leaf node then add it's value to list.
            - check for left child
                - if not null then curr = curr.left
                - if null then make curr = curr.right

        - boundary traversal:
            - base condition:
                - if root null then return

            - check if root is leaf
                - if leaf node then add it's value to the list and return.
                - else call recursive function for it's left child
                - call recursive functionn for it's right child

        - right traversal:
            - in this function we will go as right as possible without adding leaves
            - take one temp list.
            - curr = curr.right
            - loop until right is not null
            - if curr node is not leaf node then add it's value to list.
            - check for right child
                - if not null then curr = curr.right
                - else curr = curr.left
            - after loop ends reverse iterate over temp list and add element to list.


    TC: O(n) -- total nodes of tree
    SC: O(h) -- height of tree

 */

public class BoundaryTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

    public void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    public List<Integer> boundary(TreeNode root) {
        //your code goes here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }
}
