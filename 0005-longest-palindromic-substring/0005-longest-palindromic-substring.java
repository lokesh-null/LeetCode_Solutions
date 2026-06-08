class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        String op = "";

        for (int i = 0; i < length; i++){
            int start = i, end = i;
            while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            String temp = s.substring(start+1, end);
            if(temp.length() > op.length()) op = temp;

            start = i;
            end = i + 1;
            while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            temp = s.substring(start + 1, end);
            if(temp.length() > op.length()) op = temp;
        }
        return op;
    }
}