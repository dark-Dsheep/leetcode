package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2070 {


    /*
        2070. 每一个查询的最大美丽值
     */
    public int[] maximumBeauty(int[][] items, int[] queries) {
        /** 按照价格升序 价格相同按照美丽值降序 */
        Arrays.sort(items, (o1, o2) -> o1 == o2 ? o2[1] - o1[1] : o1[0] - o2[0]);
        int max = 0;
        // 将一段item里面的美丽值 更新为当前最大
        for (int[] i : items) {
            if (i[1] <= max) {
                i[1] = max;
            } else {
                max = i[1];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int target = queries[i];
            int l = 0, r = items.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (items[mid][0] > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l == 0) {
                res[i] = 0; // 没有物品可以选择
            } else {
                res[i] = items[l - 1][1];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] items = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new LC_2070().maximumBeauty(items, queries)));
    }
}
