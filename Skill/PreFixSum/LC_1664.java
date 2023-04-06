package Skill.PreFixSum;

public class LC_1664 {

    /*
        1664. 生成平衡数组的方案数
     */
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] evenPreSum = new int[n + 1];  // 偶数下标前缀和
        int[] oddPreSum = new int[n + 1];   // 奇数下标前缀和
        for (int i = 0; i < n; i++) {
            evenPreSum[i + 1] = evenPreSum[i];
            oddPreSum[i + 1] = oddPreSum[i];
            if ((i & 1) == 0) {
                evenPreSum[i + 1] += nums[i];
            } else {
                oddPreSum[i + 1] += nums[i];
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // 删除下标i元素后 后面[i+1, n)元素奇偶互换
            int a = evenPreSum[i] + oddPreSum[n] - oddPreSum[i + 1];
            int b = oddPreSum[i] + evenPreSum[n] - evenPreSum[i + 1];
            if (a == b) cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(new LC_1664().waysToMakeFair(new int[]{2, 1, 6, 4}));
    }
}
