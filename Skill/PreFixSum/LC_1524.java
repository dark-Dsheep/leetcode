package Skill.PreFixSum;

public class LC_1524 {

    /*
        1524. 和为奇数的子数组数目
     */
    private int mod = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        // 前缀和解法
        int res = 0;
        int oddSumCnt = 0;
        int evenSumCnt = 1;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                res = (res + oddSumCnt) % mod;
                evenSumCnt++;
            } else {
                res = (res + evenSumCnt) % mod;
                oddSumCnt++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(new LC_1524().numOfSubarrays(arr));
    }
}
