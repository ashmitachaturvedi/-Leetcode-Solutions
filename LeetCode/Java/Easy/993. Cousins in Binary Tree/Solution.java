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
    TreeNode Xparent = null ;
    TreeNode Yparent = null;
    int Xdepth = -1;
    int Ydepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        DFS(root,x,y,null,0);
        if(Xparent == null || Yparent == null) return false;
        if(Xparent == Yparent && Xdepth == Ydepth){
            return false;
        }
        return Xparent != Yparent && Xdepth == Ydepth;

    }
    public void DFS(TreeNode root, int x, int y, TreeNode parent, int depth){
        if(root == null) return;
        if(root.val == x){
            Xparent = parent;
            Xdepth = depth;
        }
        if(root.val == y){
            Yparent = parent;
            Ydepth = depth;
        }
        DFS(root.left,x,y,root,depth+1);
        DFS(root.right,x,y,root,depth+1);
    }
}