package Competition.weekly.wr307;

public class T2 {

    public String largestPalindromic(String num) {
        var map = new int[10];
        for (int i = 0; i < num.length(); i++) {
            map[num.charAt(i) - '0']++;
        }
        // 考虑全部为0的情况
        if (map[0] == num.length()) return "0";
        // 先构造出一半
        var sb = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            int cnt = map[i] / 2;
            sb.append((i + "").repeat(cnt));
        }
        // 处理前导零
        if (sb.length() > 0) {
            sb.append("0".repeat(map[0] / 2));
        }
        var t = new StringBuilder(sb);
        var x = sb.reverse();
        for (int i = 9; i >= 0; i--) {
            if (map[i] % 2 != 0) {
                t.append(i);
                break;
            }
        }
        return t.append(x).toString();
    }


    public static void main(String[] args) {
        var num = "00009";
        System.out.println(new T2().largestPalindromic(num));
    }
}
