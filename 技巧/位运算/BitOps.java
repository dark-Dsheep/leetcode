package 技巧.位运算;

public class BitOps {


    // 取反
    static int negate(int x) {
        return ~x + 1;
    }

    public static void main(String[] args) {
        System.out.println(negate(1));
    }
}
