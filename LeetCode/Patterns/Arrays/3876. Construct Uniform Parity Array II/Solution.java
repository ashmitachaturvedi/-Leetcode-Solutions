class Solution {
    public boolean uniformArray(int[] nums1) {
        // int n = nums1.length;
        // ArrayList<Integer> nums2 = new ArrayList<>();
        // for(int i = 0 ; i < n ; i++){
        //     if(nums1[i] % 2 == 0){
        //         nums2.add(nums1[i]);
        //     }
        //     else{
        //         boolean found = false;
        //         for(int j = 0 ; j < n ; j++){
        //             if(i != j && )
        //         }
        //         if(nums1.get(i) - nums1[i+1] >= 1){
        //             nums2.get(i) = nums1[i] - nums1[i+1];
        //         }
        //     }
        //     return true;
        // }
        // if(nums2.size() == n){
        //     return true;
        // }
        // return false;
    //     class Solution {
    // public boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;

        // Minimum odd number
        for (int x : nums1) {
            if (x % 2 == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }

        // Even number smaller than minOdd
        for (int x : nums1) {
            if (x % 2 == 0 && minOdd != Integer.MAX_VALUE && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}