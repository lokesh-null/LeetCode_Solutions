class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] prefixGcd = new int[n];

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(prefixGcd);

        int left = 0;
        int right = nums.length - 1;
        long sum = 0;

        while(left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);

            left++;
            right--;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}