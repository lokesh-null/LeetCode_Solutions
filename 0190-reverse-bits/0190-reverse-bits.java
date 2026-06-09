class Solution {
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = (reverse << 1) | ((n >> i) & 1);
        }
        return reverse;
    }
}