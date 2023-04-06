package Skill.DoublePointer;

public class LC_151 {

//    151. 反转字符串中的单词

    public String reverseWords(String s) {
        s = s.strip();
        int i = s.length() - 1;
        int j = i;
        var ans = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            ans.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') i--; // 排除中间空格
            j = i;
        }
        return ans.toString().strip();
    }

    public static void main(String[] args) {

    }
}
