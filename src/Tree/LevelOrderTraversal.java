package Tree;

import java.util.*;
import java.io.*;

/*
    - take one list.
    - to do level order traversal we will use queue.
    - if root is null then return.
    - add the root node in queue
    - now loop until queue is not empty.
    - remove one element from the start of the queue
        - add element's value into the list.
        - now if left child of element is not null then add it to queue in last.
        - do same for right child.
    - after loop end return list.
 */

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

                list.add(curr.data);
            }

            ans.add(list);
        }

        return ans;
    }
}
