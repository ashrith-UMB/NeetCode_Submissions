/*Top K Frequent Elements
        Given an integer array nums and an integer k, return the k most frequent elements within the array.

        The test cases are generated such that the answer is always unique.

        You may return the output in any order.

        Example 1:

        Input: nums = [1,2,2,3,3,3], k = 2

        Output: [2,3]
        Example 2:

        Input: nums = [7,7], k = 1

        Output: [7]
        Constraints:

        1 <= nums.length <= 10^4.
        -1000 <= nums[i] <= 1000
        1 <= k <= number of distinct elements in nums.*/

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {

        return new int[]{};
    }

    public static void main(String[] args){
        int[] array1 = new int[]{1,2,2,3,3,3};
        int[] array2 = new int[]{7,7};
        int[] array3 = new int[]{};

        TopKFrequentElements347 checker = new TopKFrequentElements347();

        System.out.println("Result for top 2 elements of {1,2,2,3,3,3} : "+ checker.topKFrequent(array1,2));
        System.out.println("Result for top 1 elements of {7,7} : "+ checker.topKFrequent(array2,1));
        System.out.println("Result for top 1 elements of {} : "+ checker.topKFrequent(array3,1));


    }
}
