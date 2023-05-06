package DataStructure.并查集;

import java.util.HashMap;

public class LC_128 {

    /*
        128. 最长连续序列
     */
    // 并查集解法
    public int longestConsecutive(int[] nums) {
        // 哈希表存储数字的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        UnionFind u = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] + 1)) { // 判断nums是否存在序列
                u.union(i, map.get(nums[i] + 1));
            }
        }
        int res = 0;
        // 统计每个连通块大小 最大的那个就是答案
        HashMap<Integer, Integer> con = new HashMap<>();
        for (Integer x : map.values()) {
            int root = u.find(x);
            con.put(root, con.getOrDefault(root, 0) + 1);
        }
        for (Integer count : con.values()) {
            res = Math.max(res, count);
        }
        return res;
    }

    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];  // 路径压缩
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            parent[aRoot] = bRoot;
            count--;
        }

        public int getCount() {
            return count;
        }
    }


    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(new LC_128().longestConsecutive(nums));
    }
}
