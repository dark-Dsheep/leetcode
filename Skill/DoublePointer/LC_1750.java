package Skill.DoublePointer;

public class LC_1750 {

    /*
        1750. 删除字符串两端相同字符后的最短长度
     */
    public int minimumLength(String s) {

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);
            if (c1 != c2) break;
            char t = c1;
            // 尝试移动左边
            while (l <= r && s.charAt(l) == t) l++;
            // 尝试移动右边
            while ( l <= r && s.charAt(r) == t) r--;
        }
        return r - l + 1;
    }

    public static void main(String[] args) {

    }
}
