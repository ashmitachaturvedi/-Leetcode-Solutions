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
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
       

        if(DFS(root) == -1) cameras++;

        return cameras;
    }
    public int DFS(TreeNode root){
        if(root == null) return 1;
        int left = DFS(root.left);
        int right = DFS(root.right);
        if(left == -1 || right == -1){
            cameras++;
            return 0;
        }
        else if(left == 1 && right == 1){
            return -1;
        }
        else{
            return 1;
        }
    }
}