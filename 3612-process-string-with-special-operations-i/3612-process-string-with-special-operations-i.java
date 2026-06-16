class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '*' && c != '#' && c != '%') {
                result.append(c);
            }
            else if (c == '#') {
                result.append(result.toString());
            }
            else if (c == '%') {
                result.reverse();
            }
            else {
                if (result.length() > 0) result.deleteCharAt(result.length() - 1);
            }
        }

        return result.toString();
    }
}