class Solution {
    public int maximumWealth(int[][] accounts) {
        int wealth = 0;
        for (int[] i : accounts) {
            int sum = 0;
            for (int money : i) {
                sum += money;
            }
            wealth = Math.max(wealth, sum);
        }
        return wealth;
    }
}