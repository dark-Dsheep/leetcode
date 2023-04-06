package DataStructure.HashMap;

public class LC_1781 {

    /*
        1781. 所有子字符串美丽值之和
     */
    public int beautySum(String s) {
        // 数据范围较小 暴力枚举
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] map = new int[26];
            for (int j = i; j < s.length(); j++) {
                map[s.charAt(j) - 'a']++;
                int maxFreq = 0, minFreq = 510;
                for (int k = 0; k < 26; k++) {
                    if (map[k] != 0) {
                        maxFreq = Math.max(maxFreq, map[k]);
                        minFreq = Math.min(minFreq, map[k]);
                    }
                }
                sum += maxFreq - minFreq;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}

