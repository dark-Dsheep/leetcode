package Algorithm.Dp;

import java.util.ArrayList;
import java.util.List;

public class LC_119 {

//    119. 杨辉三角 II
    public List<Integer> getRow(int rowIndex) {
        var all = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; i++) {          // rowIndex最多33行
            var list = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) { // 非首尾元素
                    int sum = all.get(i - 1).get(j - 1) + all.get(i - 1).get(j);
                    list.add(sum);
                } else {
                    list.add(1);
                }
            }
            all.add(list);
        }

        return all.get(rowIndex);
    }

    public static void main(String[] args) {

    }
}
