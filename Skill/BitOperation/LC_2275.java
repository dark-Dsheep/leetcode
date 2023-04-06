package Skill.BitOperation;

public class LC_2275 {

//    2275. 按位与结果大于零的最长组合

    public int largestCombination(int[] candidates) {
        // 统计每个bit位上 1的个数取最大值
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int x : candidates) {
                cnt += (x >> i & 1);
            }
            res = Math.max(res, cnt);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
