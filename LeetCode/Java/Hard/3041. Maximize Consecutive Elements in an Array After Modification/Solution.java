
class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        int maxVal = nums[nums.length - 1];

        int[] dp = new int[maxVal + 2];

        int ans = 0;

        for (int x : nums) {

            // Choice 1: Increase current element by 1
            dp[x + 1] = Math.max(
                dp[x + 1],
                dp[x] + 1
            );

            // Choice 2: Keep current element unchanged
            dp[x] = Math.max(
                dp[x],
                dp[x - 1] + 1
            );

            ans = Math.max(ans, dp[x]);
            ans = Math.max(ans, dp[x + 1]);
        }

        return ans;
    }
}
