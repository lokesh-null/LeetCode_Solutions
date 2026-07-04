class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int answer = 0;
        for(int i = 0; i < n; i += 2)
            answer += nums[i];
        return answer;
    }
}