package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_703 {
    /*
        703. 数据流中的第 K 大元素
     */
    class KthLargest {

        int k;
        PriorityQueue<Integer> queue; // 小顶堆

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {          // 不足k个元素
                queue.offer(val);
            } else if (queue.peek() < val) { // 堆顶元素 < 新元素 移除堆顶元素
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }

    public void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
    }

    public static void main(String[] args) {
        new LC_703().test();
    }
}
