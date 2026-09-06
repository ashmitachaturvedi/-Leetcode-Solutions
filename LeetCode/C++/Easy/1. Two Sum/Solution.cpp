// class Solution {
// public:
//     vector<int> twoSum(vector<int>& nums, int target) {
//         vector<int> ans;
//         int n = nums.size();
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     ans.push_back(i);
//                     ans.push_back(j);
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// };
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        map<int,int>d;
        for(int i = 0;i<nums.size();i++){
            int t = target - nums[i];
            if(d.find(t) != d.end()){
                ans.push_back(d[t]);
                ans.push_back(i);
                break;
            }
            d[nums[i]] = i;
        }   
        return ans;
    }
};      