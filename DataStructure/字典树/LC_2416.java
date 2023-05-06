package DataStructure.字典树;

import java.util.ArrayList;
import java.util.List;

public class LC_2416 {

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        Node root = new Node();
        Node cur;
        for (int i = 0; i < n; i++) {
            cur = root;
            for (char c : words[i].toCharArray()) {
                int ch = c - 'a';
                if (cur.next[ch] == null) {
                    cur.next[ch] = new Node();
                }
                cur.next[ch].score++;
                cur = cur.next[ch];
            }
            cur.ids.add(i);
        }
        int[] res = new int[n];
        dfs(root, 0, res);
        return res;
    }

    void dfs(Node node, int sum, int[] res) {
        sum += node.score;
        for (int i : node.ids) {
            res[i] += sum;
        }
        for (Node next : node.next) {
            if (next != null) {
                dfs(next, sum, res);
            }
        }
    }
    class Node {
        int score;
        Node[] next;
        List<Integer> ids;

        public Node() {
            this.next = new Node[26];
            ids = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

    }
}
