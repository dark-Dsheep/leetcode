package DataStructure.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC_1333 {

    /*
        1333. 餐厅过滤器
     */

    // 优先队列
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o2[1] - o1[1];
        }));
        for (int[] r : restaurants) {
            if (r[3] <= maxPrice && r[4] <= maxDistance) {
                if (veganFriendly == 1) {   // 考虑口味
                    if (r[2] == veganFriendly) queue.offer(r);
                } else {
                    queue.offer(r);
                }
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll()[0]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
