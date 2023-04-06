package Competition.weekly.wr325;

public class T2 {

//    每种字符至少取 K 个

//    给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
//
//  你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。

//    输入：s = "aabaaaacaabc", k = 2
//    输出：8
//    解释：
//    从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
//    从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
//    共需要 3 + 5 = 8 分钟。
//    可以证明需要的最少分钟数是 8 。


    public int takeCharacters(String s, int k) {
        int left = 0;
        int right = s.length() - 1;
        int[] map = new int[3];
        int min = 0;
        for (; left < s.length() && (map[0] < k | map[1] < k | map[2] < k); min = ++left) {
            map[s.charAt(left) - 'a']++;
        }
        for (; left > 0; min = Math.min(min, s.length() - right + left + 1)) {
            for (map[s.charAt(--left) - 'a']--; right >= 0 && map[s.charAt(left) - 'a'] < k; right--) {
                map[s.charAt(right) - 'a']++;
            }
        }
        return map[0] < k | map[1] < k | map[2] < k ? -1 : min;
    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        System.out.println(new T2().takeCharacters(s, 2));
    }
}
