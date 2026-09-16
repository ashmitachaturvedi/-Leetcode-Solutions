/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parent = new HashMap<>();
        buildParent(root, null , parent);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance == k){
                List<Integer> ans = new ArrayList<>();
                for(TreeNode node : queue){
                    ans.add(node.val);
                }
                return ans;
            }
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null && visited.add(curr.left)){
                    queue.offer(curr.left);
                }
                if(curr.right != null && visited.add(curr.right)){
                    queue.offer(curr.right);
                }
                TreeNode par = parent.get(curr);
                if(par != null && visited.add(par)){
                    queue.offer(par);
                }
            }
            distance++;
        }
        return new ArrayList<>();
    }
    private void buildParent(TreeNode node , TreeNode par , Map<TreeNode,TreeNode> parent){
        if(node == null) return;
        parent.put(node,par);
        buildParent(node.left , node , parent);
        buildParent(node.right , node , parent);
    }
}