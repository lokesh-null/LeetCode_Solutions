class Solution {
    public long maxTotalValue(int[] num, int k) {
        int max_val = Integer.MIN_VALUE, min_val = Integer.MAX_VALUE;
        for (int val : num) {
            max_val = Math.max(max_val, val);
            min_val = Math.min(min_val, val);
        }
        return 1L * (max_val - min_val) * k;
    }
}