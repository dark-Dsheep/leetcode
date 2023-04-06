package Competition.weekly.wr326;

public class T1 {

//    统计能整除数字的位数
//    给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
//
//    如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums

//    示例 1：
//
//    输入：num = 7
//    输出：1
//    解释：7 被自己整除，因此答案是 1 。


    public int countDigits(int num) {
        int count = 0;
        for (int i = num; i > 0; i /= 10) {
            count += num % (i % 10) > 0 ? 0 : 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new T1().countDigits(121));
    }
}
