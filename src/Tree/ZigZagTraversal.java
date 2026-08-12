package Tree;

import java.util.*;
import java.io.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // creating the answer list
        List<List<Integer>> ans = new ArrayList<>();
        // if root is null, return the empty the list
        if (root == null) {
            return ans;
        }

        // queue for BFS traversal
        Deque<TreeNode> q = new ArrayDeque<>();
        // add the root node
        q.offer(root);

        // if flag is even traverse left -> right else traverse right -> left
        int flag = 0;

        // while queue is not empty run the loop
        while (!q.isEmpty()) {

            // find the current size of the queue
            int size = q.size();

            // list for storing the all elements of the current level
            List<Integer> list = new ArrayList<>();

            // pop the total size elements add its data to list
            for (int i = 0; i < size; i++) {
                if (flag % 2 == 0) {
                    TreeNode curr = q.pollFirst();
                    list.add(curr.val);

                    if (curr.left != null) {
                        q.offerLast(curr.left);
                    }
                    if (curr.right != null) {
                        q.offerLast(curr.right);
                    }
                }
                else {
                    TreeNode curr = q.pollLast();
                    list.add(curr.val);

                    if (curr.right != null) {
                        q.offerFirst(curr.right);
                    }
                    if (curr.left != null) {
                        q.offerFirst(curr.left);
                    }
                }
            }

            // update the flag
            flag++;

            // add current level's list to ans
            ans.add(list);
        }

        return ans;
    }
}
