package DataStructure.Trie;

import java.util.Arrays;

public class LC_820 {


    private Node root = new Node();

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, ((o1, o2) -> o2.length() - o1.length()));
        // 将后缀转换为前缀
        // time -> emit
        // me   -> em
        int res = 0;
        for (var w : words) {
           res += insert(w);
        }
        return res;
    }

    private int insert(String ss) {
        var cur = root;
        int len = ss.length();
        boolean isNew = false;
        for (int i = len - 1; i >= 0; i--) {
            int idx = ss.charAt(i) - 'a';
            if (cur.son[idx] == null) {
                isNew = true;
                cur.isNew = true;
                cur.son[idx] = new Node();
            }
            cur = cur.son[idx];
        }
        return isNew ? ss.length() + 1 : 0;
    }

    class Node {
        Node[] son;
        boolean isNew;

        public Node() {
            this.son = new Node[26];
            this.isNew = false;
        }
    }

    public static void main(String[] args) {

    }
}
