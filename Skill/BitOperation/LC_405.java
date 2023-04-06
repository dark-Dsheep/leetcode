package Skill.BitOperation;

public class LC_405 {


    /*
        数字转换为十六进制
     */
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        // 一个int整型对应32位二进制数
        // 一位16进制对应4位二进制
        // 一个int整数可以用8位16进制数表示
        //
        for (int i = 7; i >= 0; i--) {
            // 将二进制4位一组 转成16进制
            int v = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || v > 0) {
                char digit = hexChar(v);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public char hexChar(int num) {
        if (num < 10) {
            return (char) (num + '0');
        } else {
            return (char) (num - 10 + 'a');
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC_405().toHex(26));
    }
}
