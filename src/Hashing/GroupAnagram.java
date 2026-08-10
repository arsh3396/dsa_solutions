package Hashing;

import java.util.*;
import java.io.*;

/*
    Idea:
        - take one hashmap where key: String and value: List<String>
        - iterate over array.
        - make char array of every string and sort it and make string of it.
        - if in map string as key is present then put original string into key's list
        - else create new key, value pair then put this original string into it.

        - after that take List<List<String>> ans
        - iterate over map and put every value into ans.

    TC: O(n * klog(k)) -- where n is array size and k is for sorting each char array.
    SC: O(n * k) -- in worst case there is no group so there will be n keys whose length is k.
 */

public class GroupAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);

            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(strs[i]);
        }

        for (List<String> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }
}
