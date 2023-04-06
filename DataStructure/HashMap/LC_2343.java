package DataStructure.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC_2343 {

//    2343. 裁剪数字后查询第 K 小的数字

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        // 哈希表存储每个数位裁剪后的数字
        var map = new HashMap<Integer, List<Node>>();
        int len = nums[0].length();
        for (int i = 1; i <= len; i++) {
            map.put(i, new ArrayList<>()); // 初始化map有几个位数
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = len - 1; j >= 0; j--) { // 右边保留1位,2位,k位...
                var nodes = map.get(len - j);
                nodes.add(new Node(nums[i].substring(j, len), i));
                map.put(len - j, nodes);
            }
        }
        var ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            var list = map.get(queries[i][1]);
            list.sort(((o1, o2) -> {
                if (!o1.val.equals(o2.val)) {
                    return o1.val.compareTo(o2.val);
                }
                return o1.index - o2.index;
            }));
            ans[i] = list.get(queries[i][0] - 1).index;
        }
        return ans;
    }


    class Node {
        String val;
        int index;

        public Node(String val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        String[]  nums = {"24","37","96","04"};
        int[][] q = {{2, 1}, {2, 2}};
        System.out.println(Arrays.toString(new LC_2343().smallestTrimmedNumbers(nums, q)));
    }
}
