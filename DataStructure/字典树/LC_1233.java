package DataStructure.字典树;

import java.util.ArrayList;
import java.util.List;

public class LC_1233 {


    private Node root = new Node();

    public List<String> removeSubfolders(String[] folder) {
        for (var f : folder) {
            insert(f);
        }
        var res = new ArrayList<String>();
        for (var f : folder) {
            int step = search(f);
            if (step == f.length()) {
                res.add(f);
            }
        }
        return res;
    }


    private void insert(String ss) {
        var cur = root;
        for (int i = 0; i < ss.length(); i++) {
            var ch = ss.charAt(i);
            int idx = ch == '/' ? ch - 27 : ch - 'a';
            if (cur.son[idx] == null) {
                cur.son[idx] = new Node();
            }
            cur = cur.son[idx];
        }
        cur.isEnd = true;
    }

    private int search(String ss) {
        var cur = root;
        int step = 0;
        for (int i = 0; i < ss.length(); i++) {
            var ch = ss.charAt(i);
            int idx = ch == '/' ? ch - 27 : ch - 'a';
            cur = cur.son[idx];
            step++;
            if (cur.isEnd && i + 1 < ss.length() && ss.charAt(i + 1) == '/') {
                return step;
            }
        }
        return step;
    }

    class Node {
        Node[] son;
        boolean isEnd;

        public Node() {
            this.son = new Node[27];
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        String[] folder = {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(new LC_1233().removeSubfolders(folder));

    }
}
