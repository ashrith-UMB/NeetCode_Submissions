/*
Products of Array Except Self
        Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

        Each product is guaranteed to fit in a 32-bit integer.

        Follow-up: Could you solve it in
        O
        (
        n
        )
        O(n) time without using the division operation?

        Example 1:

        Input: nums = [1,2,4,6]

        Output: [48,24,12,8]
        Example 2:

        Input: nums = [-1,0,1,2,3]

        Output: [0,-6,0,0,0]
        Constraints:

        2 <= nums.length <= 1000
        -20 <= nums[i] <= 20
*/


import java.util.Arrays;

public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        /*int multiple = 1;
        for(int num : nums){
            if(num != 0){
                multiple *= num;
            }
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                result[i] = multiple/nums[i];
            }else{
                result[i] = 0;
            }

        }

        return result;*/
        int length = nums.length;
        int[] preff = new int[length];
        int[] suff = new int[length];
        int[] result = new int[length];

        preff[0] = 1;
        suff[length - 1] = 1;

        for(int i = 1; i < length; i++){
            preff[i] = nums[i - 1] * preff[i - 1];
        }
        for(int i = length - 2; i >= 0; i--){
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        for(int i = 0; i < length; i ++){
            result[i] = preff[i] * suff[i];
        }

        return result;

    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf238 solver = new ProductOfArrayExceptSelf238();

        // Example 1
        int[] input1 = {1, 2, 4, 6};
        int[] output1 = solver.productExceptSelf(input1);
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Output: " + Arrays.toString(output1));

        // Example 2
        int[] input2 = {-1, 0, 1, 2, 3};
        int[] output2 = solver.productExceptSelf(input2);
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Output: " + Arrays.toString(output2));
    }
}
