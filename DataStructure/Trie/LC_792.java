package DataStructure.Trie;

public class LC_792 {

    private Node root = new Node();

    //TODO
    public int numMatchingSubseq(String s, String[] words) {
        for (var w : words) {
            insert(w);
        }
        return search(s);
    }

    private int search(String ss) {
        var cur = root;
        int len = ss.length(), cnt = 0;
        for (int i = 0; i < len; i++) {
            int idx = ss.charAt(i) - 'a';
            if (cur.son[idx] != null) {
                cnt += dfs(cur.son[idx]);
                cur = cur.son[idx];
            }
        }
        return cnt;
    }

    private int dfs(Node cur) {
        if (cur.isEnd) return 1;
        int cnt = 0;
        for (Node next : cur.son) {
            if (next != null) {
                cnt += dfs(next);
            }
        }
        return cnt;
    }

    private void insert(String ss) {
        var cur = root;
        int len = ss.length();
        for (int i = 0; i < len; i++) {
            int idx = ss.charAt(i) - 'a';
            if (cur.son[idx] == null) {
                cur.son[idx] = new Node();
            }
            cur = cur.son[idx];
        }
        cur.isEnd = true;
    }

    class Node {
        Node[] son;
        boolean isEnd;

        public Node() {
            this.son = new Node[26];
            this.isEnd = false;
        }
    }


    public static void main(String[] args) {

        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(new LC_792().numMatchingSubseq(s, words));
    }
}
