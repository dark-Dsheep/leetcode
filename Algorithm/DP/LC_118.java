package Algorithm.DP;

import java.util.ArrayList;
import java.util.List;

public class LC_118 {

//    118. 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        var ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            var list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) { // 非首尾元素
                    int sum = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    list.add(sum);
                } else {
                    list.add(1);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
