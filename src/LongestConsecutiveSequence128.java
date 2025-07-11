/*
Longest Consecutive Sequence
        Given an array of integers nums, return the length of the longest consecutive
        sequence of elements that can be formed.

        A consecutive sequence is a sequence of elements in which each element is exactly 1 greater
        than the previous element. The elements do not have to be consecutive in the original array.

        You must write an algorithm that runs in O(n) time.

        Example 1:

        Input: nums = [2,20,4,10,3,4,5]

        Output: 4
        Explanation: The longest consecutive sequence is [2, 3, 4, 5].

        Example 2:

        Input: nums = [0,3,2,5,4,6,1,1]

        Output: 7
        Constraints:

        0 <= nums.length <= 1000
        -10^9 <= nums[i] <= 10^9
*/


import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        /*//Basic approach : Sorting
        int maxCount = 1, count = 1, arrLength = nums.length;
        *//*if(arrLength == 1)
            return 1;*//*
        if(arrLength == 0)
            return 0;

        Arrays.sort(nums);
        for(int i = 0; i < arrLength - 1; i++){
            if(nums[i] == nums[i+1])
                continue;

            if(nums[i] == nums[i+1] - 1){
                count++;
                maxCount = Math.max(maxCount, count);
                continue;
            }
            //maxCount = Math.max(maxCount, count);
            count = 0;
        }
        return maxCount;*/


        //using HashTable would give O(n) time complexity
        int maxCount = 0;

        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        //int loopCounter = 0 ;

        for(int i = 0; i < nums.length; i++){
            //loopCounter++;
            int currentNum = nums[i];
            int count = 0;

            if(!numSet.contains(currentNum - 1)){
                while(numSet.contains(currentNum)){
                    //loopCounter++;
                    currentNum++;
                    count++;
                }
            }


            maxCount = Math.max(maxCount, count);
        }

        //System.out.println("Loops run : "+ loopCounter);
        return maxCount;

    }

    public static void main(String[] args){
        int[] array1 = new int[]{2,20,4,10,3,4,5};
        int[] array2 = new int[]{0};
        int[] array3 = new int[]{0,5};
        int[] array4 = new int[]{};



        LongestConsecutiveSequence128 checker = new LongestConsecutiveSequence128();
        System.out.println("Result of {2,20,4,10,3,4,5} : "+ checker.longestConsecutive(array1));
        System.out.println("Result of {0} : "+ checker.longestConsecutive(array2));
        System.out.println("Result of {0, 5} : "+ checker.longestConsecutive(array3));
        System.out.println("Result of {} : "+ checker.longestConsecutive(array4));

    }
}
