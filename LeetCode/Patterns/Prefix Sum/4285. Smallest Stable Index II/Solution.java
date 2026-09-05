// class Solution {
//     public int firstStableIndex(int[] nums, int k) {
//         int n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             int max = Integer.MIN_VALUE;
//             int min = Integer.MAX_VALUE;
//             for(int j = 0 ; j <= i ; j++){
//                 max = Math.max(max,nums[j]);
//             }
//             for(int j = i ; j < n ; j++){
//                 min = Math.min(min,nums[j]);
//             }
//             int score = max - min;
//             if(score <= k) return i;
//         }
//         return -1;
//     }
// }
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int score = prefixMax[i] - suffixMin[i];
            if (score <= k) {
                return i;
            }
        }
        return -1;
    }
}