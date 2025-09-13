/*Encode and Decode Strings
        Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

        Please implement encode and decode

        Example 1:

        Input: ["neet","code","love","you"]

        Output:["neet","code","love","you"]
        Example 2:

        Input: ["we","say",":","yes"]

        Output: ["we","say",":","yes"]
        Constraints:

        0 <= strs.length < 100
        0 <= strs[i].length < 200
        strs[i] contains only UTF-8 characters.*/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings271 {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;

            result.add(str.substring(i,j));
            i = j;
        }

        return result;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings271 codec = new EncodeAndDecodeStrings271();

        // Example 1
        List<String> input1 = Arrays.asList("neet", "code", "love", "you");
        String encoded1 = codec.encode(input1);
        List<String> decoded1 = codec.decode(encoded1);

        System.out.println("Input: " + input1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);

        // Example 2
        List<String> input2 = Arrays.asList("we", "say", ":", "yes");
        String encoded2 = codec.encode(input2);
        List<String> decoded2 = codec.decode(encoded2);

        System.out.println("Input: " + input2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decoded2);
    }
}
