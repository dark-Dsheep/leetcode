package 技巧.前缀和;

import java.util.Arrays;
import java.util.HashMap;

public class LC_MS1705 {

//    面试题 17.05.  字母与数字
    public String[] findLongestSubarray(String[] arr) {
        // 把字母看作-1 数字看作1
        // 那么问题包含相同字母和数字的个数的最长子数组 -> 就是求和为0的最长子数组
        int s = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int pos = -1, len = 0; // pos记录左端点下标最小的子数组,len记录子数组最大长度
        for (int i = 0; i < arr.length; i++) {
            s += Character.isDigit(arr[i].charAt(0)) ? 1 : -1;
            if (map.containsKey(s)) {
                if (i - map.get(s) > len) { // 只能大于之前维护的len才更新pos
                    pos = map.get(s)+1;
                    len = i - map.get(s);
                }
            } else {
                map.put(s, i);
            }
        }
        if (pos == -1) return new String[0];
        return Arrays.copyOfRange(arr, pos, pos+len);
    }

    public static void main(String[] args) {

    }
}
