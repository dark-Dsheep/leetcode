package DataStructure.String;

public class LC_1910 {

    /*
        1910. 删除一个字符串中所有出现的给定子字符串
     */

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            for (int i = 0; i < s.length(); i++) {
                if (s.length() - i < part.length() && s.substring(i, part.length() + 1).equals(part)) {
                    s = s.substring(0, i) + s.substring(part.length());
                }
            }
        }
        return s;
    }


    public static void main(String[] args) {
        String s = "aabababa";
        String part = "aba";
        System.out.println(new LC_1910().removeOccurrences(s, part));
    }
}
