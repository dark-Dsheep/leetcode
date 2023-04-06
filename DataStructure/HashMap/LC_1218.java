package DataStructure.HashMap;

import java.util.HashMap;

public class LC_1218 {


    /*
        1218. 最长定差子序列
     */

    public int longestSubsequence(int[] arr, int diff) {
        // 哈希表存储以num 结尾的最长定差子序列的长度
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] - diff)) {
                int len = map.get(arr[i] - diff);
                // 更新定差子序列长度
                map.put(arr[i], len + 1);
                res = Math.max(res, len + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
