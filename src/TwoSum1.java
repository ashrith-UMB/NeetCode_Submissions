/*
* Given an array of integers nums and an integer target, return the indices i and j such
* that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.
*
* Example 1:

Input:
nums = [3,4,5,6], target = 7

Output: [0,1]
Explanation: nums[0] + nums[1] == 7, so we return [0, 1].

Example 2:

Input: nums = [4,5,6], target = 10

Output: [0,2]
Example 3:

Input: nums = [5,5], target = 10

Output: [0,1]
Constraints:

2 <= nums.length <= 1000
-10,000,000 <= nums[i] <= 10,000,000
-10,000,000 <= target <= 10,000,000

* */

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {

        /*Brute Force - O(n^2) time complexity

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};*/

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return  new int[] {map.get(complement) , i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution found");
    }

    public static void main(String[] args){
        TwoSum1 checker = new TwoSum1();

        int[] array1 = {3,4,5,6};
        int[] result1 = checker.twoSum(array1, 7);
        System.out.println("Result 1 : {"+ result1[0]+","+ result1[1]+"}");

        int[] array2 = {1,2,5,6};
        try {
            int[] result2 = checker.twoSum(array2, 9);
            System.out.println("Result 2 : {"+ result2[0]+","+ result2[1]+"}");
        } catch (IllegalArgumentException e) {
            System.out.println("Result 2 : " + e.getMessage());
        }

        int[] array3 = {1,2,3,4,5,6,7};
        try {
            int[] result3 = checker.twoSum(array3, 18);
            System.out.println("Result 3 : {"+ result3[0]+","+ result3[1]+"}");
        } catch (IllegalArgumentException e) {
            System.out.println("Result 3 : " + e.getMessage());
        }

    }
}

