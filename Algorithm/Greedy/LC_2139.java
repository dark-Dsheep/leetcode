package Algorithm.Greedy;

public class LC_2139 {

    /*
        2139. 得到目标值的最少行动次数
     */

    public int minMoves(int target, int maxDoubles) {
        // 从target 减少到1的最少操作次数
        // target是奇数 并且 maxDoubles不为0
        // target - 1 变偶数 然后 / 2
        // target是奇数 maxDoubles不为0 -> target / 2
        // maxDoubles = 0 操作次数 = target - 1 + 前面加倍的操作数
        if (maxDoubles == 0) return target - 1;
        int cnt = 0;
        while (target != 1 && maxDoubles != 0) {
            if ((target & 1) == 0) {
                target /= 2;
                maxDoubles -= 1;
            } else {
                target -= 1;
            }
            cnt++;
        }
        return cnt + target - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LC_2139().minMoves(19, 2));
    }
}
