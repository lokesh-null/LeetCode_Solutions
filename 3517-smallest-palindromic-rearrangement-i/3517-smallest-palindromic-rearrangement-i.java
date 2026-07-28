class Solution {
    public String smallestPalindrome(String s) {
        char firstChar = s.charAt(0);

        int[] chFreq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            int charIndex = (int) s.charAt(i) - 'a';
            chFreq[charIndex]++;
        }

        char[] result = new char[s.length()];
        
        int resultIndex = 0;
        for(int i = 0; i < 26; i++) {
            while(chFreq[i] >= 2) {
                char ch = (char) (i + 'a');
                result[resultIndex] = ch;
                int diff = s.length() - 1 - resultIndex;
                result[diff] = ch;
                resultIndex++;
                chFreq[i] -= 2;
            }
            if(chFreq[i] == 1) {
                int mid = s.length() / 2;
                result[mid] = s.charAt(mid);
            }
        }

        return new String(result);
    }
}