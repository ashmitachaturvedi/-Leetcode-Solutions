// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n = nums.length;
//         if(n == 0) return 0;
//         Arrays.sort(nums);
//         int count = 1;
//         int maxCount = 1;
//         for(int i = 1 ; i < n ; i++){
//             if(nums[i] == nums[i-1]+1){
//                 count++;
//             }
//             else if(nums[i] == nums[i-1]){
//                 continue;
//             }
//             else count = 1;
//             maxCount = Math.max(maxCount , count);
//         }
//         return maxCount;
//     }
// }

// 2nd approach - optimal
// hashset use krenge ham 
class Solution{
    public int longestConsecutive(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxCount = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int count = 1;
                int current = num;
                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
                maxCount = Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}