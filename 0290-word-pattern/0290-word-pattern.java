class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> mp = new HashMap<>();
        String arr[] = s.trim().split("\\s+");

        if (pattern.length() != arr.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (mp.containsKey(ch)) {
                if (!mp.get(ch).equals(arr[i])) {
                    return false;
                }
            }
            else {
                if (mp.containsValue(arr[i])) 
                    return false;

                mp.put(ch, arr[i]);
            }
        }
        return true;
    }
}