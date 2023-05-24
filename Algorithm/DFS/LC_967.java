package Algorithm.DFS;

import java.util.*;

public class LC_967 {


    /*
        967. 连续差相同的数字
     */
    List<Integer> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
//        for (int i = 1; i <= 9; i++) {
//            bfs(i, n, k);
//        }
        dfs(n, k, new StringBuilder());
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    // 解法二：回溯
    public void dfs(int n, int k, StringBuilder sb) {
        if (sb.length() == n) {
            list.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (sb.length() == 0 && i == 0) continue;   // 不能包含前导零
            if (sb.length() == 0 || Math.abs(sb.charAt(sb.length() - 1) - '0' - i) == k) {
                sb.append(i);
                dfs(n, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // 解法一：BFS
    public void bfs(int start, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 1});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int curNum = p[0], bitCnt = p[1];
            int bitNum = curNum % 10;
            if (bitCnt == n) {  //
                list.add(curNum);
            }
            for (int i = 0; i <= 9; i++)  {
                if (bitCnt >= n) continue;
                if (Math.abs(i - bitNum) == k) {
                    int nextNum = curNum * 10 + i;
                    queue.offer(new int[]{nextNum, bitCnt +  1});
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC_967().numsSameConsecDiff(2, 0)));
    }
}
