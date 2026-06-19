class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int index = 0; index < s.length(); index++){
            if (map1[s.charAt(index)] != map2[t.charAt(index)])
            return false;

            map1[s.charAt(index)] = index + 1;
            map2[t.charAt(index)] = index + 1;
        }
        return true;

    }
}