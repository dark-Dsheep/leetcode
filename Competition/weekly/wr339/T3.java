package Competition.weekly.wr339;


import java.util.Arrays;
import java.util.PriorityQueue;

public class T3 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = Arrays.stream(reward2).sum();
        int n = reward1.length;
        var pq = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < n; i++) {
            pq.offer(reward1[i] - reward2[i]);
        }
        for (int i = 0; i < k; i++) {
            ans += pq.poll();
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] a = {2, 2, 1, 2};
        int[] b = {1, 2, 1, 2};
        int k = 2;
        System.out.println(new T3().miceAndCheese(a, b, k));
    }
}
