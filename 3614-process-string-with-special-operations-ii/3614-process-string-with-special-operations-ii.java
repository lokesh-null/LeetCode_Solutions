class Solution {
    public char processStr(String s, long k) {
        long length = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                length++;
            }
            else if(c == '*') {
                if (length > 0) length--;
            }
            else if (c == '#') {
                length *= 2;
            }
        }

        if (k >= length) return '.';

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                if (k == length - 1) return c;
                length--;
            }
            else if (c == '#') {
                length /= 2;
                k %= length;
            }
            else if (c == '%') {
                k = length - 1- k;

            }
            else {
                long oldLength = length + 1;
                if ( k == oldLength - 1) {
                    return '.';
                }
                length = oldLength;
            }
        }

        return '.';
    }
}