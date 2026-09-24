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
    class Pair{
        TreeNode node;
        int row;
        int col;
        Pair(TreeNode node, int row , int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Pair> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0 , 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            list.add(p);
            if(p.node.left != null) q.offer(new Pair(p.node.left, p.row +1, p.col - 1));
            if(p.node.right != null) q.offer(new Pair(p.node.right, p.row + 1, p.col + 1));            
        }
        list.sort((a, b) -> {
            if(a.col != b.col) return a.col -  b.col;
            if(a.row != b.row) return a.row - b.row;
            return a.node.val - b.node.val;
        });
        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        for(Pair p : list){
            if(p.col != prevCol){
                ans.add(new ArrayList<>());
                prevCol = p.col;
            }
            ans.get(ans.size() - 1).add(p.node.val);
        }
        return ans;
    }
}