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
    public TreeNode convertBST(TreeNode root) {
        if(root== null) return root;
        TreeNode curr = root;
        int sum = 0;
        while(curr != null){
            if(curr.right == null){
                sum += curr.val;
                curr.val = sum;
                curr = curr.left;
            }
            else{
                TreeNode succ = curr.right;
                while(succ.left != null && succ.left != curr){
                    succ = succ.left;
                }
                if(succ.left == null){
                    // seedhi nhi bani - right not visited yet
                    succ.left = curr;
                    curr = curr.right;
                }
                else{
                    // right has been visited -- seedhi bani hui h
                    sum += curr.val;
                    curr.val = sum;
                    succ.left = null;
                    curr = curr.left;
                }
            } // else closed
        } // while closed
        return root;
    }
}