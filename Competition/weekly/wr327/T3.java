package Competition.weekly.wr327;

import java.util.HashSet;

public class T3 {


    public static boolean isItPossible(String word1, String word2) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (char c : word1.toCharArray()) set1.add(c);
        for (char c : word2.toCharArray()) set2.add(c);
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int len = Math.min(ch1.length, ch2.length);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (ch1[i] != ch2[i]) {
                count++;
            }
        }
        System.out.println(count);
        if (count <= 1) return false;
        return Math.abs(set1.size() - set2.size()) <= 1 && Math.abs(ch1.length - ch2.length) <= 1;
    }


    public static void main(String[] args) {
        System.out.println(isItPossible("aa", "bbd"));
    }
}
