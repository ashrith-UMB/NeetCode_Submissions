/*
Given an integer array nums, return true if any value appears more
than once in the array, otherwise return false.

Input: nums = [1, 2, 3, 3]

Output: true

Input: nums = [1, 2, 3, 4]

Output: false
*/


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    //Brute Force (( O(n^2) time complexity))
    /*public boolean hasDuplicate(int[] nums) {

         for(int i = 0; i < nums.length; i++ ){
             for(int j = i + 1; j < nums.length; j++){
                 if(nums[i] == nums[j])
                     return true;
             }
         }

         return false;

     }*/

    //you can sort and check the adjacent values to but the time complexity will be O(nlogn)
    //Using HashSet ( O(n) time complexity)
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> number = new HashSet<>();

        for (int num : nums) {
            if (number.contains(num))
                return true;
            number.add(num);
        }
        return false;

    }

    public static void main(String[] args) {
        ContainsDuplicate217 checker = new ContainsDuplicate217();

        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Test Case 1: " + checker.hasDuplicate(nums1)); // Expected: true
        System.out.println("Test Case 2: " + checker.hasDuplicate(nums2)); // Expected: false
    }

}
