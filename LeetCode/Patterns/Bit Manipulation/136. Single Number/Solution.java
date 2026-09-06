class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int single_num = nums[0];
        for (int a : nums) {
            ans ^= a;
        }
        return ans;
    }
}