class Solution {
    public boolean isPerfectSquare(int num) {
        long begin = 1, end = num;
        while(begin <= end) {
            long mid = begin + (end - begin) / 2;
            if (mid * mid == num) return true;

            else if(mid * mid > num) end = mid - 1;

            else begin = mid + 1;
        }
        return false;
    }
}