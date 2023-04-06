package Algorithm.BinarySearch;

import java.util.Arrays;

public class LC_2300 {

    /*
        2300. 咒语和药水的成功对数
     */


    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        int index = 0;
        for (int spell : spells) {
            // 二分答案
            int l = 0;
            int r = potions.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (((long) potions[mid] * spell) >= success) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if ((long) potions[r] * spell >= success) { // 是成功的组合才记录
                res[index] = potions.length - r;
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        int success = 16;
        System.out.println(Arrays.toString(new LC_2300().successfulPairs(spells, potions, success)));
    }

}
