package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_1845 {

    /*
        1845. 座位预约管理系统
     */
    class SeatManager {

        PriorityQueue<Integer> queue;   // 小顶堆

        public SeatManager(int n) {
            queue = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                queue.offer(i);         // 初始化1-n的座位
            }
        }

        public int reserve() {
            return queue.poll();        // 弹出最小编号
        }

        public void unreserve(int seatNumber) {
            queue.offer(seatNumber);    // 加入队列
        }
    }


    public static void main(String[] args) {

    }
}
