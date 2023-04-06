package Competition.weekly.wr326;

public class T3 {

//    将字符串分割成值不超过 K 的子字符串
//    给你一个字符串 s ，它每一位都是 1 到 9 之间的数字组成，同时给你一个整数 k 。
//
//    如果一个字符串 s 的分割满足以下条件，我们称它是一个 好 分割：
//
//    s 中每个数位 恰好 属于一个子字符串。
//    每个子字符串的值都小于等于 k 。
//    请你返回 s 所有的 好 分割中，子字符串的 最少 数目。如果不存在 s 的 好 分割，返回 -1 。
//
//    注意：
//
//    一个字符串的 值 是这个字符串对应的整数。比方说，"123" 的值为 123 ，"1" 的值是 1 。
//    子字符串 是字符串中一段连续的字符序列。

//    输入：s = "165462", k = 60
//    输出：4
//    解释：我们将字符串分割成子字符串 "16" ，"54" ，"6" 和 "2" 。每个子字符串的值都小于等于 k = 60 。
//    不存在小于 4 个子字符串的好分割。

    public int minimumPartition(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); count++) {
            if (s.charAt(i) - '0' > k) {
                return -1;
            }
            for (long curr = 0; i < s.length() && (curr = curr * 10 + s.charAt(i) - '0') <= k; i++) {
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new T3().minimumPartition("165462", 60));
    }

}
