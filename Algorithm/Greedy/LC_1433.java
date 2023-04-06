package Algorithm.Greedy;

import java.util.Arrays;

public class LC_1433 {


    /*
        1433. 检查一个字符串是否可以打破另一个字符串
     */
    public boolean checkIfCanBreak(String s1, String s2) {
        boolean f1 = true, f2 = true;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            // 尝试打破s2
            if (chars1[i] < chars2[i]) {
                f1 = false;
            }
            // 尝试打破s1
            if (chars2[i] < chars1[i]) {
                f2 = false;
            }
        }
        return f1 || f2;
    }

    public static void main(String[] args) {

        System.out.println(new LC_1433().checkIfCanBreak("abc", "xya"));
    }
}
