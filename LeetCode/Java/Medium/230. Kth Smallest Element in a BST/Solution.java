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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Inorder(root,ans);
        return ans.get(k-1);
    }
    void Inorder(TreeNode root,ArrayList<Integer> ans){
        if(root == null) return;
        Inorder(root.left,ans);
        ans.add(root.val);
        Inorder(root.right,ans);
    }
}
// class Solution {

//     public int kthSmallest(TreeNode root, int k) {

//         ArrayList<Integer> arr = new ArrayList<>();

//         Inorder(root, arr);

//         return arr.get(k - 1);
//     }

//     void Inorder(TreeNode root, ArrayList<Integer> arr) {

//         if (root == null) return;

//         Inorder(root.left, arr);

//         arr.add(root.val);

//         Inorder(root.right, arr);
//     }
// }