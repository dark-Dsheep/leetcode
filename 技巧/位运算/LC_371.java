package 技巧.位运算;

public class LC_371 {

    /*
        371. 两整数之和
     */

    public int getSum(int a, int b) {
        // res = 不进位的和 + 进位的和
        while (b != 0) {
            int sum = a ^ b; // 不进位的和
            int carry = (a & b) << 1; // 进位的和
            a = sum;
            b = carry;
        }
        return a;
    }


    public static void main(String[] args) {

        System.out.println(new LC_371().getSum(14, 8));
//        System.out.println(14 ^ 8);
    }
}
