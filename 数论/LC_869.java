package 数论;

import java.util.HashSet;

public class LC_869 {

    /*
        869. 重新排序得到 2 的幂
     */
    HashSet<String> set = new HashSet<>() {
        {
            for (int i = 0; i < 32; i++) {
                add(String.valueOf((int) Math.pow(2, i)));
            }
        }
    };

    public boolean reorderedPowerOf2(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int[] map = new int[10];
        for (char c : chars) {
            map[c - '0']++;
        }
        for (String num : set) {
            char[] ch = num.toCharArray();
            int[] count = new int[10];
            for (char c : ch) {
                count[c - '0']++;
            }
            boolean flag = true;
            // 统计每一位上面的数字个数
            for (int i = 0; i < 10; i++) {
                if (count[i] != map[i]) {
                    flag = false;
                }
            }
            if (flag) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
