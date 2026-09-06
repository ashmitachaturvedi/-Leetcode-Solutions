// class Solution {
//     public boolean check(int[] nums) {
//         int n = nums.length;
//         for(int x = 0 ; x < n ; x++){
//             int[] nums2 = new int[n];
//             for(int i = 0 ; i < n ; i++){
//                 nums2[i] = nums[(i+x)%n];
//             }
//             boolean sorted = true;
//             for (int i = 1; i < n; i++) {
//                 if (nums2[i] < nums2[i - 1]) {
//                     sorted = false;
//                     break;
//                 }
//             }
//             if (sorted) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}