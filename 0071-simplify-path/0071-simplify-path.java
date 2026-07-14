class Solution {
    public String simplifyPath(String path) {

        Stack<String> st = new Stack<>();
        String[] components = path.split("/");

        for (String component : components) {

            if (component.equals("") || component.equals(".")) {
                continue;
            }

            if (component.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(component);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        for (String dir : st) {
            res.append("/").append(dir);
        }

        return res.toString();
    }
}