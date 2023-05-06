package DataStructure.字典树;

public class LC_211 {

//    211. 添加与搜索单词 - 数据结构设计
    static class WordDictionary {

        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            insert(word);
        }

        public boolean search(String word) {
            var cur = root;
            return dfs(word, cur, 0);
        }

        boolean dfs(String w, Node root, int idx) {
            if (root == null) return false;
            if (idx >= w.length()) return root.isEnd;
            // 当前字符是'.'
            if (w.charAt(idx) == '.') {
                for (var child : root.son) {
                    if (dfs(w, child, idx + 1)) return true;
                }
            } else {
                int i = w.charAt(idx) - 'a';
                return dfs(w, root.son[i], idx + 1);
            }
            return false;
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
        }

        static class Node {
            Node[] son;
            boolean isEnd;

            public Node() {
                son = new Node[26];
                isEnd = false;
            }
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        System.out.println(dictionary.search("pad"));
        System.out.println(dictionary.search("bad"));
        System.out.println(dictionary.search(".ad"));
        System.out.println(dictionary.search("b.."));

    }
}
