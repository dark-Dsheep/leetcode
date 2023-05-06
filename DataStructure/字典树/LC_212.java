package DataStructure.字典树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_212 {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    HashSet<String> ans = new HashSet<>();
    Node root = new Node();
    Node cur;
    boolean[][] vis;
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        vis = new boolean[m + 1][n + 1];
        for (var w : words) insert(w);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cur = root.son[board[i][j] - 'a'];
                dfs(board, cur, i, j);
            }
        }
        return new ArrayList<>(ans);
    }

    void dfs(char[][] board, Node cur, int x, int y) {
        if (cur == null) return;
        if (cur.isEnd) { ans.add(cur.word); } // 该路径存在一个单词
        vis[x][y] = true;
        for (var d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
            dfs(board, cur.son[board[nx][ny] - 'a'], nx, ny);
        }
        vis[x][y] = false;
    }

    void insert(String w) {
        var cur = root;
        int len = w.length();
        for (int i = 0; i < len; i++) {
            int idx = w.charAt(i) - 'a';
            if (cur.son[idx] == null) {
                cur.son[idx] = new Node();
            }
            cur = cur.son[idx];
        }
        cur.isEnd = true;
        cur.word = w;
    }

    class Node {
        Node[] son;
        boolean isEnd;
        String word;

        public Node() {
            son = new Node[26];
            isEnd = false;
            word = "";
        }
    }

    public static void main(String[] args) {

    }
}
