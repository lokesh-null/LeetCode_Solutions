class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode temp = q.remove();

            if(temp == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                continue;
            }

            if(temp.left != null){
                q.add(temp.left);
            }

            if(temp.right != null){
                q.add(temp.right);
            }

            if(q.peek() == null){
                ans.add(temp.val);
            }
        }

        return ans;
    }
}