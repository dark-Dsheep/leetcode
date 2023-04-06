package DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC_1387 {

    int[] memo = new int[1010];
    /*
        1387. 将整数按权重排序
     */
    public int getKth(int lo, int hi, int k) {
        Arrays.fill(memo, -1);
        // 第i个数字的权重
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            if (memo[i] != -1) {
                queue.offer(new int[]{i, memo[i]});
            } else {
                queue.offer(new int[]{i, count(i)});
            }
        }
        while (k-- > 1) {
            queue.poll();
        }
        return queue.poll()[0];
    }

    public int count(int x) {
        int step = 0;
        while (x != 1) {
            if ((x & 1) == 0) {
//                x = x / 2;
                x >>= 1;
            } else {
//                x = 3 * x + 1;
                x += (x << 1) + 1;
            }
            step += 1;
        }
        memo[x] = step;
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1387().getKth(10, 20, 5));
    }
}
