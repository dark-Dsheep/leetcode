package DataStructure.字典树;

public class LC_1032 {

//    1032. 字符流
    class StreamChecker {

        StringBuilder stream = new StringBuilder();

        Node root = new Node();

        public StreamChecker(String[] words) {
            for (var s : words) {
                insert(s);
            }
        }

        public boolean query(char letter) {
            stream.append(letter);
            return find(stream);
        }

        boolean find(StringBuilder s) {
            var cur = root;
            int n = s.length();
            for (int i = n-1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                if (cur.son[idx] == null) return false;
                cur = cur.son[idx];
                if (cur.isEnd) return true;
            }
            return false;
        }

        void insert(String s) {
            var cur = root;
            int n = s.length();
            for (int i = n-1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
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

            public Node(){
                son = new Node[26];
                isEnd = false;
            }
        }
    }



    public static void main(String[] args) {

    }
}
