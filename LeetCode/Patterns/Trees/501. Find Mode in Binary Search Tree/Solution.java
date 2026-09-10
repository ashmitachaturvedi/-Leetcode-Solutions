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
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        inorder(root,map);
        int max = 0;
        for(int count : map.values()){
            max = Math.max(max,count);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                ans.add(key);
            }
        }
            int[] result = new int[ans.size()];
            for(int i = 0 ; i < ans.size() ; i++){
                result[i] = ans.get(i);
            }
            return result;
    }
    public void inorder(TreeNode root,HashMap<Integer,Integer> map){
        if(root == null) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);

        inorder(root.left,map);
        inorder(root.right,map);
    }
}