package Tree;

import java.util.*;
import java.io.*;

/*
    - to get top view of tree we will use horizontal distance of nodes.
    - root node is distance 0, left is at -1 and right is at 1
    - this is main idea of this problem

    Idea:
        - make one pair class that stores node and distance
        - make one list to store ans.
        - make one treemap that stores distance as key and val as value.
        - take one queue to do BFS traversal.

        - if root is null then return empty list.
        - add root to queue.
        - loop until queue is not empty.
        - poll one element.
        - get it's distance and node.
        - if map don't contains distance as key then add this root.
        - if node's left is not then add left into the queue and do same for right child.

        - after loop ends iterate over map's value and add them to list
        - return list at the end

    TC: O(n * log(n)) -- n is node count and n * log(n) for sorting because we are using treemap
    SC: O(n)
 */

public class TopView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }
}

class Pair{
    int hd;
    Node node;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int hd = curr.hd;
            Node node = curr.node;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        for (int value : map.values()) {
            list.add(value);
        }

        return list;
    }
}
