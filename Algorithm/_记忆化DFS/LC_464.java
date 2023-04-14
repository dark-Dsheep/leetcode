package Algorithm._记忆化DFS;


public class LC_464 {

    /*
        LC-464.我能赢吗
     */

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // state = 0, 表示公共整数池中所有数字都未被使用过
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }

    // 状态压缩 TODO
    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        // 遍历可选择的公共整数
        for (var x = 1; x <= maxChoosableInteger; x++) {
            // 如果 x 已经被使用了, 则不能选择
            if (((1 << x) & state) == 0) continue;
            // 如果选择了x后, 大于等于 desiredTotal, 当前玩家赢
            if (sum + x >= desiredTotal) return true;
            // 改变公共整数池状态
            // 当前玩家选择了 x 以后, 判断对方玩家是否一定输?
            if (!dfs((1 << x) | state, sum + x, maxChoosableInteger, desiredTotal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int state = 0;
        state = (1 << 1) | state;

    }


}
