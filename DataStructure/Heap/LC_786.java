package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_786 {

    /*
        786. 第 K 个最小的素数分数
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 大顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double t = arr[i] * 1.0 / arr[j];
                if (queue.size() < k || queue.peek()[0] * 1.0 / queue.peek()[1] > t) {
                    if (queue.size() == k) queue.poll();
                    queue.offer(new int[]{arr[i], arr[j]});
                }
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {

    }
}
