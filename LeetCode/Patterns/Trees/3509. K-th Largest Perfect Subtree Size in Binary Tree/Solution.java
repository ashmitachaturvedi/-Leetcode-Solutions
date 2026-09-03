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
    ArrayList<Integer> arr = new ArrayList<>();

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        DFS(root);
        Collections.sort(arr,Collections.reverseOrder());
        if(arr.size() < k) return -1;
        else return arr.get(k-1);
    }
    public Pair<Boolean,Integer> DFS(TreeNode root){
        if(root == null){
            return new Pair<>(true,0);
        }
        Pair<Boolean,Integer> left = DFS(root.left);
        Pair<Boolean,Integer> right = DFS(root.right);
        boolean leftPerfect = left.getKey();
        boolean rightPerfect = right.getKey();
        int leftSize = left.getValue();
        int rightSize = right.getValue();
        
        if (leftPerfect && rightPerfect && leftSize == rightSize) {

            int size = leftSize + rightSize + 1;
            arr.add(size);

            return new Pair<>(true, size);
        }

        return new Pair<>(false, 0);
    }
}