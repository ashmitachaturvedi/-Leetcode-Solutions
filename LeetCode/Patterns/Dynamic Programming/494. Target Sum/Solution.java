class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }

    public int solve(int[] nums, int index, int sum, int target) {

        if (index == nums.length) {
            if (sum == target)
                return 1;

            return 0;
        }

        int add = solve(nums, index + 1, sum + nums[index], target);

        int subtract = solve(nums, index + 1, sum - nums[index], target);

        return add + subtract;
    }
}