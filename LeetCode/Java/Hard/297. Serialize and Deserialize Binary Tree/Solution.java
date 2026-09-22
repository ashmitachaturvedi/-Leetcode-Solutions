/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public void serializeHelper(TreeNode root , StringBuilder sb) {
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }
    public TreeNode deserialize(String data){
        String[] values = data.split(",");
        index = 0;
        return buildTree(values);
    }
    private TreeNode buildTree(String[] values){
        if(values[index].equals("null")){
            index++;

            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        index++;
        root.left = buildTree(values);
        root.right = buildTree(values);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));