package Skill.PreFixSum;

import java.util.HashMap;

public class LC_523 {


    /*
        523. 连续的子数组和
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0) return true;
        }
        // if (k < 0)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 如果后面的sum % k 在前面出现过, [left, i]这个区间和是k的倍数
            if (map.containsKey(sum % k)) {
                int left = map.get(sum % k);
                if (i - left > 1) return true;
            } else {
                map.put(sum % k, i);    // 只记录sum % k首次出现的位置
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
