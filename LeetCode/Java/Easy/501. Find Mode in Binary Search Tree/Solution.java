/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public int[] findMode(TreeNode root) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         inorder(root,map);
//         int max = 0;
//         for(int count : map.values()){
//             max = Math.max(max,count);
//         }
//         ArrayList<Integer> ans = new ArrayList<>();
//         for(int key : map.keySet()){
//             if(map.get(key) == max){
//                 ans.add(key);
//             }
//         }
//             int[] result = new int[ans.size()];
//             for(int i = 0 ; i < ans.size() ; i++){
//                 result[i] = ans.get(i);
//             }
//             return result;
//     }
//     public void inorder(TreeNode root,HashMap<Integer,Integer> map){
//         if(root == null) return;
//         map.put(root.val,map.getOrDefault(root.val,0)+1);

//         inorder(root.left,map);
//         inorder(root.right,map);
//     }
// }

class Solution {

    int maxCount = 0;
    int curCount = 0;
    int prev = Integer.MIN_VALUE;

    ArrayList<Integer> ans = new ArrayList<>();

    public void inorder(TreeNode root) {

        if (root == null) return;

        inorder(root.left);

        int cur = root.val;

        if (cur == prev)
            curCount++;
        else
            curCount = 1;

        if (curCount > maxCount) {
            maxCount = curCount;
            ans.clear();
            ans.add(cur);
        }
        else if (curCount == maxCount) {
            ans.add(cur);
        }

        prev = cur;

        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {

        inorder(root);

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}