package DataStructure.Tree;


import utils.Node;

public class LC_426 {

    Node head; // 保存头节点
    Node pre;   // 保存前驱节点

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        // 连接首尾节点
        pre.right = head;
        head.left = pre;
        return head;
    }

    void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (head == null) {
            head = root;
            pre = head;
        } else {
            // 连接上一个节点pre
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}
