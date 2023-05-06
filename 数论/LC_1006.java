package 数论;

import java.util.LinkedList;

public class LC_1006 {

    /*
        1006. 笨阶乘 TODO
     */
    int[] step = {0, 1, 2, 3};

    public int clumsy(int n) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int num = n;
        sb.append(n).append(" ");
        while (num != 1) {
            if (index == 0) {
                num -= 1;
                sb.append("*").append(" ").append(num).append(" ");
                index += 1;
            }
            else if (index == 1) {
                num -= 1;
                sb.append("/").append(" ").append(num).append(" ");
                index += 1;
            }
            else if (index == 2) {
                num -= 1;
                sb.append("+").append(" ").append(num).append(" ");
                index += 1;
            }
            else if (index == 3) {
                num -= 1;
                sb.append("-").append(" ").append(num).append(" ");
                index = 0;
            }
        }
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> optStack = new LinkedList<>();
        int res = 0;
        String exp = sb.toString().trim();

        System.out.println(exp);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1006().clumsy(10));
    }
}
