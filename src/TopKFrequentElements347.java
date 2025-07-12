/*Top K Frequent Elements
        Given an integer array nums and an integer k, return the k most frequent elements
        within the array.

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countFrequentElements = new HashMap<>();
        Arrays.sort(nums);

        for(int num : nums){
            if(countFrequentElements.containsKey(num)){
                int currentCount = countFrequentElements.get(num);
                countFrequentElements.replace(num, currentCount, currentCount + 1);
            }else {
                countFrequentElements.put(num, 1);
            }
        }
        ArrayList<Integer> resultArray = new ArrayList<>();

        for(int key : countFrequentElements.keySet()){
            if(countFrequentElements.get(key) >= k)
                resultArray.add(key);
        }

        int[] result = new int[resultArray.size()];
        for(int i = 0; i < resultArray.size(); i++){
            result[i] = resultArray.get(i);
        }

        return result;
    }

    public static void main(String[] args){
        int[] array1 = new int[]{1,1,1,1,2,2,3,3,3};
        int[] array2 = new int[]{7,7};
        int[] array3 = new int[]{};

        TopKFrequentElements347 checker = new TopKFrequentElements347();

        System.out.println("Result for top 3 elements of {1,1,1,1,2,2,3,3,3} : ");
        int[] resultArray = checker.topKFrequent(array1,3);
        System.out.print("[");
        for(int i = 0; i < resultArray.length; i++){
            System.out.print(resultArray[i]+",");
        }
        System.out.println("]");
        System.out.println("Result for top 1 elements of {7,7} : ");
        resultArray = checker.topKFrequent(array2,1);
        System.out.print("[");
        for(int i = 0; i < resultArray.length; i++){
            System.out.print(resultArray[i]+",");
        }
        System.out.println("]");
        System.out.println("Result for top 1 elements of {} : ");
        resultArray = checker.topKFrequent(array3,1);
        System.out.print("[");
        for(int i = 0; i < resultArray.length; i++){
            System.out.print(resultArray[i]+",");
        }
        System.out.println("]");


    }
}
