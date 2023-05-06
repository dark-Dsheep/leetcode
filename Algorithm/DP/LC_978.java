package Algorithm.DP;

public class LC_978 {

//    978. 最长湍流子数组

    // 类似题目 LC_376.摆动序列
    public int maxTurbulenceSize(int[] arr) {
        // 滚动变量优化
        int[] f = {1, 1};
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                f[0] = f[1] + 1;
                f[1] = 1;
            } else if (arr[i] < arr[i-1]) {
                f[1] = f[0] + 1;
                f[0] = 1;
            } else {
                f[0] = f[1] = 1;    // 考虑子数组
            }
            ans = Math.max(ans, Math.max(f[0], f[1]));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
