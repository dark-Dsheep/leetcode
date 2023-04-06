package Skill.PreFixSum;

import java.util.HashMap;

public class LC_525 {

    /*
        525. 连续数组
     */
    public int findMaxLength(int[] nums) {
        // 前缀和 边走边记录
        // 遇到0 减一 遇到1 加一
        int sum = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // 哨兵
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1] == 1 ? 1 : -1;
            if (map.containsKey(sum)) { // 前面出现过sum 更新res
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);        // 只记录sum第一次出现 使得区间长度越大
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
