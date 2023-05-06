package DataStructure.字典树;

public class LC_421 {

//    421. 数组中两个数的最大异或值

    Node root = new Node();

    public int findMaximumXOR(int[] nums) {
        for (int num : nums) insert(num);
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, find(num));
        }
        return ans;
    }

    int find(int x) {
        var cur = root;
        int max = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (x >> i) & 1;
            if (cur.son[bit ^ 1] != null) {
                cur = cur.son[bit ^ 1];
                max <<= 1;
                max += 1;  // 左移1位并且加1，加1的原因是这一步表示0^1=1
            } else {
                cur = cur.son[bit];
                max <<= 1;
            }
        }
        return max;
    }

    void insert(int x) {
        var cur = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (x >> i) & 1;
            if (cur.son[bit] == null) {
                cur.son[bit] = new Node();
            }
            cur = cur.son[bit];
        }
    }

    // 01Trie
    static class Node {
        Node[] son;
        public Node() {
            son = new Node[2];
        }
    }


    public static void main(String[] args) {

    }
}
