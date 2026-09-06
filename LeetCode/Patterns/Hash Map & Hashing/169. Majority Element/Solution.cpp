class Solution {
public:
    int majorityElement(vector<int>& nums) {
        // int n = nums.size();
        // for (int i = 0; i < n; i++) {
        //     int count = 0;
        //     for (int j = 0; j < n; j++) {
        //         if (nums[j] == nums[i]) {
        //             count++;
        //         }
        //     }
        //     if (count > n / 2) {
        //         return nums[i];
        //     }
        // }
        // return -1;

            //APPROACH 2
        // sort(nums.begin(),nums.end());
        // return nums[(int)nums.size()/2];

        //APPROACH 3
        int n =  nums.size();
        unordered_map<int,int>m;
        for(auto a:nums){
            m[a]++;
            if(m[a]>n/2)
           return a;
        }
         return -1;
    }
};

