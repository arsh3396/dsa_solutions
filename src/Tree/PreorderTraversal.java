package Tree;

import java.util.*;
import java.io.*;

/*
    - make one ans list in preorder function.
    - make one recursive function.
        - if root == null return
        - then add root's value in list.
        - now call the recursive function for left child.
        - after that call recursive function for right child.
 */

public class PreorderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<Integer> preorder(TreeNode root) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        pre(root, ans);
        return ans;
    }

    void pre(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        pre(root.left, list);
        pre(root.right, list);
    }
}
