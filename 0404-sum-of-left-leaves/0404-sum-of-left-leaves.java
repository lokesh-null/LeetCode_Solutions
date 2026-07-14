class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) { 
            return 0;
        }
        int leafSum = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            leafSum += root.left.val;
        }
        leafSum += sumOfLeftLeaves(root.left);
        leafSum += sumOfLeftLeaves(root.right);
        return leafSum;
    } 
}
