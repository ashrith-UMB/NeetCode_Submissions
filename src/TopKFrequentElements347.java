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

import java.util.*;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countFrequentElements = new HashMap<>();
        //Arrays.sort(nums);

        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        for(int num : nums){
            if(countFrequentElements.containsKey(num)){
                int currentCount = countFrequentElements.get(num);
                countFrequentElements.replace(num, currentCount, currentCount + 1);
            }else {
                countFrequentElements.put(num, 1);
            }
        }


        List<int[]> array = new ArrayList<>();

        for(Map.Entry<Integer, Integer> map : countFrequentElements.entrySet()){
            array.add(new int[]{map.getValue(), map.getKey()});
        }

        array.sort((a,b) -> b[0] - a[0]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = array.get(i)[1];
        }




        //Optimized using heap sort

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        return result;

    }

    public static void main(String[] args){
        int[] array1 = new int[]{1,1,1,1,2,2,3,3,3};
        int[] array2 = new int[]{7,7};
        int[] array3 = new int[]{1,2};

        TopKFrequentElements347 checker = new TopKFrequentElements347();

        System.out.println("Result for top 3 elements of {1,1,1,1,2,2,3,3,3} : ");
        int[] resultArray = checker.topKFrequent(array1,2);
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
        System.out.println("Result for top 2 elements of {1,2} : ");
        resultArray = checker.topKFrequent(array3,2);
        System.out.print("[");
        for(int i = 0; i < resultArray.length; i++){
            System.out.print(resultArray[i]+",");
        }
        System.out.println("]");


    }
}
