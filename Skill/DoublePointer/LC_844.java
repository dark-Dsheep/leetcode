package Skill.DoublePointer;

public class LC_844 {

//    844. 比较含退格的字符串
    public boolean backspaceCompare(String s, String t) {
        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (c == '#') {
                if (sb1.length() > 0) sb1.deleteCharAt(sb1.length() - 1);
            } else {
                sb1.append(c);
            }
        }
        for (var c : t.toCharArray()) {
            if (c == '#') {
                if (sb2.length() > 0) sb2.deleteCharAt(sb2.length() - 1);
            } else {
                sb2.append(c);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        var s = "y#fo##f";
        var t = "y#f#o##f";
        System.out.println(new LC_844().backspaceCompare(s, t));
    }
}
