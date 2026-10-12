class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        long[] values = new long[k];
        for (int i = 0; i < 31; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            for (int j = 0; j < Math.min(count, k); j++) {
                values[j] |= (1L << i);
            }
        }
        long ans = 0;
        for (long value : values) {
            ans = (ans + value * value) % MOD;
        }
        return (int) ans;
    }
}
