package Skill.BitOperation;

public class LC_191 {

    /*
        191. 位1的个数
     */
    public int hammingWeight(int n) {
        int res = 0;
//        while (n != 0) {
//            res += (n & 1); // 从最低位开始每次判断1位
//            n = n >>> 1;    // 右移判断下一位
//        }
        // 写法2
        for (int i = 31; i >= 0; i--) {
            res += ((n >> i) & 1); // 判断每一位是不是1
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_191().hammingWeight(00000000000000000000000000001011));
    }
}
