package Tree;

import java.util.*;
import java.io.*;

/*
    Idea:
        - take one list.
        - use standard BFS traversal
        - at each level find size of the queue
        - and loop a for loop from 0 to size
        - if i is size - 1 then add that element's val into list.

    TC: O(N)
    SC: O(W) --width of binary tree
 */

public class RightSideView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();

                if (i == size - 1) {
                    list.add(temp.val);
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
        }

        return list;
    }
}
