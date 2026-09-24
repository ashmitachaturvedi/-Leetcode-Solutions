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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            TreeNode rightNode = null;

            for (int i = 0; i < n; i++) {
                rightNode = que.poll();

                if (rightNode.left != null) {
                    que.add(rightNode.left);
                }
                if (rightNode.right != null) {
                    que.add(rightNode.right);
                }
            }

            result.add(rightNode.val); 
        }

        return result;
    }
}