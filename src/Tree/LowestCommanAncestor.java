package Tree;

import java.util.*;
import java.io.*;

/*
    Idea:
        - we have to find the lca of both numbers.
        - make one recursive funcion
        - base conditions:
            - if current root is null, then return null
            - if current root's value is same as one of n1 or n2 then return current root.
        - now root is not null and root's value is not equals to n1 and n2.
        - we don't know which side lca is located.
        - so we call function for both side and store that answer.
        - if both function don't return null then current root is lca.
        - if one of them is null that means in that part we haven't found anything so we will return other side's answer.
        - if left is null then return right.
        - else right is null then return left.

    TC: O(N)
    SC: O(H)
 */

public class LowestCommanAncestor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    Node lca(Node root, int n1, int n2) {
        // code here
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        if (left == null) {
            return right;
        }
        return left;
    }
}
