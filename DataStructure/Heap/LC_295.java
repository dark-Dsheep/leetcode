package DataStructure.Heap;

import java.util.PriorityQueue;

public class LC_295 {

//    295. 数据流的中位数
    static class MedianFinder {

    PriorityQueue<Integer> minHeap; // 小顶堆 存储较大的一半元素
    PriorityQueue<Integer> maxHeap; // 大顶堆 存储较小的一半元素

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    // 当前数据流的元素个数是奇数时, minHeap的元素个数比maxHeap的元素个数多 1
    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) { // 添加一个元素, 数据流个数变奇数
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {                                // 添加一个元素, 数据流个数变偶数
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // 数据流元素个数为奇数, 那么大顶堆堆顶元素就是中位数
            return minHeap.peek();
        }
    }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
//        MedianFinder finder = new MedianFinder();
//        for (int x : arr) finder.addNum(x);
    }

}
