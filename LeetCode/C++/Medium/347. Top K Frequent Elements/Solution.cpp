// class Solution {
// public:
//     vector<int> topKFrequent(vector<int>& nums, int k)
//     {
//         unordered_map<int,int>umap;
//         for(auto x:nums)
//         {
//             umap[x]++;

//         }
//         priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
//         for(auto x:umap)// Take element from Umap
//         {
//             // push the Secound part first into the Pair  ,For Pushing the Pair we use Make-pair
//             pq.push(make_pair(x.second,x.first));
//             // maintan the Size K
//             if(pq.size()>k)
//                 pq.pop();

//         }
//         // Remaing K size Heap Do Pop
//         vector<int>ans;

//         while(!pq.empty())
//         {
//             pair<int,int> temp=pq.top();
//             pq.pop();
//             ans.push_back(temp.second);

//         }
//         return ans;

       
//     }
// };
// Approach 2 
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int, int> mp;
        for(int &num : nums) {
            mp[num]++;
        }
        vector<vector<int>> bucket(n+1);
        for(auto &it : mp) {
            int element = it.first;
            int freq    = it.second;
            bucket[freq].push_back(element);
        }
        vector<int> result;
        for(int i = n; i >= 0; i--) {
            if(bucket[i].size() == 0) continue;
            int size = bucket.size();
            while(bucket[i].size() > 0 && k > 0) {
                result.push_back(bucket[i].back());
                bucket[i].pop_back();
                k--;
            }
           
        }
       
        return result;
    }
};