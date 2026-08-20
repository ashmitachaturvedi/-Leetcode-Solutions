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
//     public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//         if(root1 == null) return root2;
//         if(root2 == null) return root1;
//         root1.val = root1.val + root2.val;
//         root1.left = mergeTrees(root1.left,root2.left);
//         root1.right = mergeTrees(root1.right,root2.right);
//         return root1;
//     }
// }
// using stack
class Solution{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[] {root1,root2});
        while(!st.isEmpty()){
            // nikalo -> process -> child push
            // nikalo
            TreeNode[] p = st.pop();
            TreeNode t1 = p[0];
            TreeNode t2 = p[1];
            // process
            //if(t1 == null || t2 == null)continue;
            t1.val = t1.val + t2.val;
            // push child 
            if(t1.left == null) t1.left = t2.left;
            else if (t2.left != null) st.push(new TreeNode[] {t1.left,t2.left});
            if(t1.right == null) t1.right = t2.right;
            else if (t2.right != null) st.push(new TreeNode[] {t1.right,t2.right});            
        }
    return root1;
    }
}