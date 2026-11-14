
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();

        int[] prefix = new int[n + 1];

        // Build prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        // Try every starting position
        for (int i = 0; i < n; i++) {

            // Try every allowed subarray length
            for (int len = l; len <= r; len++) {

                int end = i + len;

                if (end > n) {
                    break;
                }

                int sum = prefix[end] - prefix[i];

                if (sum > 0) {
                    ans = Math.min(ans, sum);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
