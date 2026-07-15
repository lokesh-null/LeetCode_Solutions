class Solution {
    List<List<Integer>> Ans = new ArrayList<>();
    int n;

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> op = new ArrayList<>();
        n = nums.length;

     
        Helper(op, nums, 0);

        return Ans;
    }

    public void Helper(List<Integer> op, int[] nums, int startIndex) {
        
        if (startIndex == n) {
            Ans.add(new ArrayList<>(op));
            return;
        }

        
        op.add(nums[startIndex]);
        Helper(op, nums, startIndex + 1);

        
        op.remove(op.size() - 1);

        
        Helper(op, nums, startIndex + 1);
    }
}