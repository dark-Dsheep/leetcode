package Algorithm.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_792 {

//    792. 匹配子序列的单词数

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length(), ans = 0;
        var map = new HashMap<Character, List<Integer>>();
        // 哈希表预处理
        for (int i = 0; i < n; i++) {
            var list = map.getOrDefault(s.charAt(i), new ArrayList<Integer>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        for (var w : words) {
            var ok = true;
            int m = w.length(), idx = -1;
            for (int i = 0; i < m && ok; i++) {
                var list = map.getOrDefault(w.charAt(i), new ArrayList<Integer>());
                int l = 0, r = list.size() - 1;
                // 二分找第一个 大于 idx的位置
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) > idx) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                if (r < 0 || list.get(l) <= idx) ok = false;
                else idx = list.get(l);
            }
            if (ok) ans++;
        }
        return ans;
    }
}
