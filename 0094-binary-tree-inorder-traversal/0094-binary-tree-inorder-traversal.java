class Solution {
    void f(TreeNode node, List<Integer > l){
        if(node==null){
            return;
        }
        f(node.left,l);
        l.add(node.val);
        f(node.right,l);
        return;
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer > l = new ArrayList<>();
        f(root,l);
        return l;
    }
}