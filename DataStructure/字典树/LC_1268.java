package DataStructure.字典树;

import java.util.ArrayList;
import java.util.List;

public class LC_1268 {

    private Node root = new Node();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var res = new ArrayList<List<String>>();
        for (var ss : products) {
            insert(ss);
        }
        int len = searchWord.length();
        for (int i = 0; i < len; i++) {
            var prefix = searchWord.substring(0, i + 1);
            res.add(search(prefix));
        }
        return res;
    }

    private List<String> search(String prefix) {
        var cur = root;
        int len = prefix.length();
        var list = new ArrayList<String>();
        for (int i = 0; i < len; i++) {
            int idx = prefix.charAt(i) - 'a';
            // 不存在prefix前缀
            if (cur.son[idx] == null) return list;
            cur = cur.son[idx];
        }
        dfs(cur, list);
        list.sort(((o1, o2) -> o1.compareTo(o2)));
        return list.size() > 3 ? list.subList(0, 3) : list;
    }

    private void dfs(Node cur, List<String> list) {
        if (cur.isEnd) {
            list.add(cur.data);
        }
        for (var next : cur.son) {
            if (next != null) {
                dfs(next, list);
            }
        }
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
        cur.data = ss;
    }

    class Node {
        Node[] son;
        boolean isEnd;
        String data;

        public Node() {
            this.son = new Node[26];
            this.isEnd = false;
            this.data = "";
        }
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(new LC_1268().suggestedProducts(products, searchWord));
    }
}
