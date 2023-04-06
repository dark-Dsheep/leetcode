package DataStructure.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC_658 {

    // 解法1 堆
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        var pq = new PriorityQueue<Integer>((a, b) -> {
            var v1 = Math.abs(a - x);
            var v2 = Math.abs(b - x);
            if (v1 == v2) return b - a;
            return v2 - v1;
        });
        for (int num : arr) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        var res = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        res.sort((o1, o2) -> o1 - o2);
        return res;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int i = l, j = l;
        var res = new ArrayList<Integer>();
        res.add(arr[l]);
        k--;
        while (k > 0) {
            if (i > 0) {
                res.add(arr[--i]);
                k--;
            }
            if (k == 0) break;
            res.add(arr[++j]);
            k--;
        }
        res.sort(((o1, o2) -> o1 - o2));
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,10,10,10};
        int k = 1;
        int x = 9;
        System.out.println(new LC_658().findClosestElements1(arr, k, x));
    }
}
