package DataStructure.HashMap;

import java.util.HashMap;

public class LC_2295 {

    /*
        2295. 替换数组中的元素
     */
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 记录每个num的下标
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] o : operations) {
            int index = map.get(o[0]);
            nums[index] = o[1];
            map.put(o[1], index);
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
