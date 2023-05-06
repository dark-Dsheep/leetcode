package 技巧.位运算;

public class LC_504 {

    /*
        504. 七进制数
     */

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int x = Math.abs(num);
//        将十进制 转成 k进制 通用
        while (x != 0) {
            sb.append(x % 7);
            x /= 7;
        }
        String res = sb.reverse().toString();
        return num < 0 ? "-" + res : res;
    }

    public static void main(String[] args) {
        System.out.println(new LC_504().convertToBase7(-7));
    }
}
