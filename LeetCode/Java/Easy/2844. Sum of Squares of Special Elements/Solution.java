class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int square = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(n % (i + 1) == 0){
                square = nums[i] * nums[i];
                sum += square;
            }
        }
        return sum;
    }
}