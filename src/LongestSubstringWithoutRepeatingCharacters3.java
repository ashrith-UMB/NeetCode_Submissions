import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {



        /* Wrong approach - goes wrong for string "dvdf"
        Set<Character> stringSet = new HashSet<Character>();
        int count = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            if(stringSet.contains(s.charAt(i))){
                if(count > max)
                    max = count;

                count = 1;
                stringSet.clear();
                stringSet.add(s.charAt(i));
                continue;
            }
            stringSet.add(s.charAt(i));
            count++;
        }
        return Math.max(count, max);*/

        //SLIDING WINDOW APPROACH
        Set<Character> charSet = new HashSet<Character>();
        int max = 0, left = 0;

        for(int right = 0; right < s.length(); right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args){
        String s1 = "abcabcbc";
        String s2 = "zxyzxyz";
        String s3 = "dvdf";

        LongestSubstringWithoutRepeatingCharacters3 checker = new LongestSubstringWithoutRepeatingCharacters3();

        System.out.println("Result of s1: "+s1+" "+ checker.lengthOfLongestSubstring(s1));
        System.out.println("Result of s2: "+s2+" "+ checker.lengthOfLongestSubstring(s2));
        System.out.println("Result of s3: "+s3+" "+ checker.lengthOfLongestSubstring(s3));

    }
}
