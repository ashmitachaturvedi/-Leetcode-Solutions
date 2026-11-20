
class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        int prev = Integer.MIN_VALUE;
        int count = 0;
        int ans = 0;

        for (int x : nums) {

            if (x > prev + 1) {
                prev = x;
                count = 1;
            }
            else if (x == prev + 1) {
                prev = x;
                count++;
            }
            else if (x == prev) {
                prev = x + 1;
                count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }
}
