import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int op = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();
        
        for (int right = 0; right < length; right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            op = Math.max(op, right - left + 1);
        }
        return op;
    }
}