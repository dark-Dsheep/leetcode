package Skill.DoublePointer;

public class LC_1147 {

    public int longestDecomposition(String t) {
        var a = new StringBuilder();
        var b = new StringBuilder();
        int i = 0, j = t.length() - 1;
        int ans = 0;
        while (i <= j) {
            a.append(t.charAt(i));
            b.append(t.charAt(j));
            if (check(a, b)) {
                if (i == j) ans += 1; // 重合部分
                else ans += 2;
                a = new StringBuilder();
                b = new StringBuilder();
            }
            i++;
            j--;
        }
        if (a.length() > 0) ans += 1; // 特判
        return ans;
    }

    boolean check(StringBuilder a, StringBuilder b) {
        if (a.length() != b.length()) return false;
        for (int i = 0, j = b.length() - 1; i < a.length(); i++, j--) {
            if (a.charAt(i) != b.charAt(j)) return false;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
