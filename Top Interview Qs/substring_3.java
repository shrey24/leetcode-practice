import java.util.HashMap;

/*
3. Longest Substring Without Repeating Characters
Example:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/ 
class substring_3{
    
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        HashMap<Character, Integer> dict = new HashMap<>(); //<char at, index>
        int maxLength = 0, currentLength = 0;
        while( end < s.length()){
            if( dict.get(s.charAt(end)) == null ){
                dict.put(s.charAt(end), end);
                end++;
                if (end-start >= maxLength){
                    maxLength = end-start;
                }
            }
            else{ //s.charAt(end) is repeated.

                start = dict.get(s.charAt(end)) + 1; // move start to (old repeated char)+1
                // dict.put(s.charAt(end), end); //update dict to reflect new pos. of s[end]
                // update dict
                dict.clear();
                for(int i = start; i<=end; i++){
                    dict.put(s.charAt(i), i);
                }
                end++;                
            }
        }

        return maxLength;
    }
    
    

    public static void main(String[] args) {
        String s1 = "pwwkew", s2 = "abcabcbb", s3 = "bbbbb";
        System.out.println(s1 + " - " + lengthOfLongestSubstring(s1));
        System.out.println(s2 + " - " + lengthOfLongestSubstring(s2));
        System.out.println(s3 + " - " + lengthOfLongestSubstring(s3));
    }
    
}