package Tree;

import java.util.*;
import java.io.*;

/*
    - make one list in class.
    - now make one recursive function
        - if root is null then return.
        - now call recursive function for the left child
        - add the root's data in list.
        - now call recursive function for the right child.
    - call the recursive function from the inorder function and return the list.
 */

public class InorderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    ArrayList<Integer> arr = new ArrayList<>();

    public ArrayList<Integer> inOrder(Node root) {
        // code here
        traversal(root);
        return arr;
    }

    void traversal(Node root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        arr.add(root.data);
        traversal(root.right);
    }
}
