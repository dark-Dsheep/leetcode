package Algorithm.Greedy;

import java.util.ArrayList;
import java.util.List;

public class LC_763 {

    // 763. 划分字母区间
    public List<Integer> partitionLabels(String s) {
        var last = new int[126]; // last[i]表示第i个字母最后出现的位置
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i)] = i;
        }
        var ans = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i)]);
            if (end == i) { // 将s[start:end]划为一个片段
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
