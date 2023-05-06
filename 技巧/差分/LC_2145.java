package 技巧.差分;

public class LC_2145 {

    /*
        2145. 统计隐藏数组数目
     */
    public int numberOfArrays(int[] diff, int lower, int upper) {

        // diff -> 差分数组
        int a = 0;
        int d = upper - lower;
        int max = 0, min = 0;
        // 计算原数组的上下界 差值
        for (int i = 0; i < diff.length; i++) {
            a += diff[i];
            max = Math.max(a, max);
            min = Math.min(a, min);
            if (max - min > d) return 0;
        }
        // ----------min----[lower----max----upper]
        // 计算有多少个数组 上下界在 [lower, upper]中
        return d - max + min + 1;
    }

    public static void main(String[] args) {

        int[] diff = {1, -3, 4};
        System.out.println(new LC_2145().numberOfArrays(diff, 1, 6));
    }
}
