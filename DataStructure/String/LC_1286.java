package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

public class LC_1286 {


    /*
        1286. 字母组合迭代器
        回溯
     */

    class CombinationIterator {
        private String data;
        private List<String> list;
        private int combinationLength;
        private int cur = 0;

        public CombinationIterator(String characters, int combinationLength) {
            this.data = characters;
            this.list = new ArrayList<>();
            this.combinationLength = combinationLength;
            this.dfs(0, new StringBuilder());
        }

        public String next() {
            String temp = list.get(cur);
            cur++;
            return temp;
        }

        public boolean hasNext() {
            return cur < list.size();
        }

        private void dfs(int start, StringBuilder sb) {
            if (sb.length() == combinationLength) {
                list.add(sb.toString());
                return;
            }
            for (int i = start; i < data.length(); i++) {
                sb.append(data.charAt(i));
                dfs(i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new LC_1286().new CombinationIterator("abc", 2);
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
