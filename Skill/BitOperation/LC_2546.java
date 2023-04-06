package Skill.BitOperation;

public class LC_2546 {

    /*
        2546. 执行逐位运算使字符串相等
     */
    public boolean makeStringsEqual(String s, String target) {
        // 1.如果 s 和 t 都有 1      -> true
        // 2.s 和 t 只有其中有个有1  -> false
        // 3.s 和 t 都没有1          -> true

        // if (s.equals(target)) return true;
        // boolean f1 = false, f2 = false;
        // for (var c : s.toCharArray()) {
        //     if (c == '1') {
        //         f1 = true;
        //         break;
        //     }
        // }
        // for (var c : target.toCharArray()) {
        //     if (c == '1') {
        //         f2 = true;
        //         break;
        //     }
        // }
        // return f1 && f2;
        return s.contains("1") == target.contains("1");
    }

    public static void main(String[] args) {

    }
}
