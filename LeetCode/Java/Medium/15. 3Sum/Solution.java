class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    if(i != j && i != k && j != k){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            List<Integer> triplet = new ArrayList<>();
                            triplet.add(nums[i]);
                            triplet.add(nums[j]);
                            triplet.add(nums[k]);
                            Collections.sort(triplet);
                            if(!ans.contains(triplet)) ans.add(triplet);
                        }
                    }
                }
            }
        }
        return ans;
    }
}

