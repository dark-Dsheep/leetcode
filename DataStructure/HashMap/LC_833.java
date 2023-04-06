package DataStructure.HashMap;

import java.util.HashMap;

public class LC_833 {


    /*
        833. 字符串中的查找与替换
        TODO
     */

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            map.put(sources[i], targets[i]);
        }
        for (int index : indices) {
            for (int i = index; i < s.length(); i++) {
                int j = index;
                String temp = "";
                while (j < s.length()) {
                    String str = s.substring(i, j);
                    if (map.containsKey(str)) {
                        temp = map.get(str);
                        break;
                    }
                    j++;
                }
                // [index, j] 替换 -> temp
                String prefix = s.substring(0, index);
                String suffix = s.substring(j);
                System.out.println("suffix : " + suffix);
                s = prefix + temp + suffix;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "fff"};
        System.out.println(new LC_833().findReplaceString(s, indices, sources, targets));
    }
}
