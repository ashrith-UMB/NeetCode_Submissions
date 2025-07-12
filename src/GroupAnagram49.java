/*
Group Anagrams
        Given an array of strings strs, group all anagrams together into sublists.
        You may return the output in any order.

        An anagram is a string that contains the exact same characters as another string,
        but the order of the characters can be different.

        Example 1:

        Input: strs = ["act","pots","tops","cat","stop","hat"]

        Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        Example 2:

        Input: strs = ["x"]

        Output: [["x"]]
        Example 3:

        Input: strs = [""]

        Output: [[""]]
        Constraints:

        1 <= strs.length <= 1000.
        0 <= strs[i].length <= 100
        strs[i] is made up of lowercase English letters.
*/



import java.util.*;

public class GroupAnagram49 {
    public List<List<String>> groupAnagrams(String[] strs) {


       // List<List<String>> result = new LinkedList<>();
        HashMap<String, List<String>> resultMap = new HashMap<>();

        //Time Complexity - O(m*nlogn) - m being the number of strings, n being the longest string
        //Space Complexity - O(m*n)
        for(String str : strs){
            char[] charArray =  str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            resultMap.putIfAbsent(sortedString, new ArrayList<>());
            resultMap.get(sortedString).add(str);
        }

        return new ArrayList<>(resultMap.values());

    }

    public static void main(String[] args){
        GroupAnagram49 checker = new GroupAnagram49();
        String[] string1 = new String[]{"act","pots","tops","cat","stop","hat"};
        String[] string2 = {"x"};
        String[] string3 = {""};

        System.out.println("Example 1: " + checker.groupAnagrams(string1));
        System.out.println("Example 2: " + checker.groupAnagrams(string2));
        System.out.println("Example 3: " + checker.groupAnagrams(string3));


    }
}
