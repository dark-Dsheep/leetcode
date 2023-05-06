package 技巧.位运算;

public class LC_190 {

    /*
        190. 颠倒二进制位
     */
    //TODO
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1 | n & 1);
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_190().reverseBits(964176192 ));
    }
}
