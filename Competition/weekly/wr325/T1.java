package Competition.weekly.wr325;

public class T1 {

//    到目标字符串的最短距离

//    给你一个下标从 0 开始的 环形 字符串数组 words 和一个字符串 target 。环形数组 意味着数组首尾相连。
//
//    形式上， words[i] 的下一个元素是 words[(i + 1) % n] ，而 words[i] 的前一个元素是 words[(i - 1 + n) % n] ，其中 n 是 words 的长度。
//    从 startIndex 开始，你一次可以用 1 步移动到下一个或者前一个单词。
//
//    返回到达目标字符串 target 所需的最短距离。如果 words 中不存在字符串 target ，返回 -1 。


    public int closetTarget(String[] words, String target, int startIndex) {
        for (int i = 0; i < words.length; i++) {
            if (words[(startIndex + i) % words.length].equals(target) ||
                words[(startIndex - i + words.length) % words.length].equals(target)
            ) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] words = {"hello","i","am","leetcode","hello"};
        String target = "hello";
        System.out.println(new T1().closetTarget(words, target, 1));
    }
}
