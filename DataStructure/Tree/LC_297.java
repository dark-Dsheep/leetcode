package DataStructure.Tree;



import utils.TreeNode;

import java.util.LinkedList;

public class LC_297 {



    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            var sb = new StringBuilder();
            var q = new LinkedList<TreeNode>(){{add(root);}};
            while (q.size() > 0) {
                var node = q.poll();
                if (node != null) {
                    sb.append(node.val).append("#");
                    q.offer(node.left);
                    q.offer(node.right);
                } else {
                    sb.append("null").append("#");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("null")) return null;
            String[] vals = data.split("#");
            var root = new TreeNode(Integer.parseInt(vals[0]));
            var q = new LinkedList<TreeNode>(){{offer(root);}};
            int i = 1;
            while (q.size() > 0) {
                var node = q.poll();
                if (!vals[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    q.offer(node.left);
                }
                i++;
                if (!vals[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    q.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
