class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int index = 0; index < nums.length; index++) {
            if (hash.contains(nums[index])){
                return true;
            }
            hash.add(nums[index]);
        }
        return false;
    }
}