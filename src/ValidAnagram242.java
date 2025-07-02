/*
Given two strings s and t, return true if the two strings are anagrams of each other,
 otherwise return false.

An anagram is a string that contains the exact same characters as another string,
 but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true

Example 2:

Input: s = "jar", t = "jam"

Output: false

*/


import java.util.Arrays;


public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        if(s.length() != t.length())
            return false;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            count[ch - 'a']++;

            ch = t.charAt(i);
            count[ch - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(count[i] > 0)
                return false;
        }

        return true;

        /*
        O(log n + m) time complexity
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);*/
    }

    public static void main(String[] args) {
        ValidAnagram242 checker = new ValidAnagram242();

        String s1 = "racecar";
        String t1 = "carrace";

        String s2 = "jar";
        String t2 = "jam";

        String s3 = "money";
        String t3 = "honey";

        System.out.println("Test Case 1: " + checker.isAnagram(s1, t1)); // Expected: true
        System.out.println("Test Case 2: " + checker.isAnagram(s2, t2)); // Expected: false
        System.out.println("Test Case 3: " + checker.isAnagram(s3, t3)); // Expected: false

    }

}
