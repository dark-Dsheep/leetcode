package DataStructure.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_646 {

    //TODO
    public int findLongestChain(int[][] pairs) {
        //  最长数对链 -> 划分不相交区间的组的最大个数
        Arrays.sort(pairs, ((o1, o2) -> o1[0] - o2[0]));
        var pq = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
        var count = new int[pairs.length];
        Arrays.fill(count, 1);
        pq.offer(pairs[0][1]);
        for (var i = 1; i < pairs.length; i++) {
            var cur = pairs[i];
            if (pq.peek() < cur[0]) {
                // 划分为一组
                count[i]++;
            } else {

            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
