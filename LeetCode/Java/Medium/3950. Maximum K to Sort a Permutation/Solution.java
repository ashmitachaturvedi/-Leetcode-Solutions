
class Solution {
    public int sortPermutation(int[] nums) {

        int k = -1;

        for (int i = 0; i < nums.length; i++) {

            // Check if element is misplaced
            if (nums[i] != i) {

                // Calculate bitwise AND
                k &= nums[i];
            }
        }

        // If array is already sorted, return 0
        return k == -1 ? 0 : k;
    }
}
