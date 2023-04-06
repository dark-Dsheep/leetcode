package DataStructure.Queue;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LC_1561 {

    /*
        1561. 你可以获得的最大硬币数目
     */

    public int maxCoins(int[] piles) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(piles);
        for (int x : piles) deque.addLast(x);
        int res = 0;
        while (!deque.isEmpty()) {
            deque.pollLast();
            res += deque.pollLast();
            deque.pollFirst();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(new LC_1561().maxCoins(piles));
    }
}
