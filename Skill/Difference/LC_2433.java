package Skill.Difference;

public class LC_2433 {
//    2433. 找出前缀异或的原始数组
    public int[] findArray(int[] pref) {
        int n = pref.length;
        var res = new int[n];
        res[0] = pref[0];
        // 前缀和的差分是原数组，直接两两异或即可
        for (int i = 1; i < n; i++) {
            res[i] = pref[i] ^ pref[i - 1]; // 差分还原数组
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
