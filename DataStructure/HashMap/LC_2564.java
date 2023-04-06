package DataStructure.HashMap;

import java.util.HashMap;

public class LC_2564 {

//    2564. 子字符串异或查询

    static final int[] NOT_FOUND = {-1, -1};

    public int[][] substringXorQueries(String s, int[][] queries) {
        // 将 val ^ first[i] == second[i] 两边同时 xor first[i]
        // val ^ first[i] ^ first[i] == second[i] ^ first[i]
        // 化简得到 val == second[i] ^ first[i]

        // 使用哈希表预处理所有长度不超过30的二进制子串
        var map = new HashMap<Integer, int[]>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int bound = Math.min(n, i + 30);
            for (int j = i; j < bound; j++) {
                int key = Integer.parseInt(s.substring(i, j + 1), 2);
                int[] val = map.get(key);
                if (val == null || j - i < val[1] - val[0]) {
                    map.put(key, new int[]{i, j});
                }
            }
        }
        int m = queries.length;
        var ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            ans[i] = map.getOrDefault(queries[i][0] ^ queries[i][1], NOT_FOUND);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
