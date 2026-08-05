package Hashing;

import java.util.*;

/*
    Brute Force:
        Idea:
            - sort the array.
            - check if any element is present multiple times or not.

        TC: O(n logn) -- due to sorting
        SC: O(1) -- not taking any extra space

    Optimal:
        Intuition:
            - we can use set to track if element is previously seen or not.

        Idea:
            - iterate over the array and check if the element is present in set or not.
            - if it is present return true.
            - else add that element into set
            - outside loop return false.

        TC: O(n) -- traversing on array
        SC: O(n) -- in worst case all elements are unique and will be added into the set.

 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i : nums){
            if(!s.add(i)){
                return true;
            }
        }
        return false;
    }
}

